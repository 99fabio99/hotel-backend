package com.fabiozanela.hotel.services;

import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabiozanela.hotel.domain.Agenda;
import com.fabiozanela.hotel.domain.Estacionamento;
import com.fabiozanela.hotel.domain.Quarto;
import com.fabiozanela.hotel.domain.Reserva;
import com.fabiozanela.hotel.domain.Veiculo;
import com.fabiozanela.hotel.dto.AgendaDTO;
import com.fabiozanela.hotel.dto.EstacionamentoDTO;
import com.fabiozanela.hotel.dto.QuartoDTO;
import com.fabiozanela.hotel.dto.ReservaNewDTO;
import com.fabiozanela.hotel.dto.VeiculoDTO;
import com.fabiozanela.hotel.repositories.AgendaRepository;
import com.fabiozanela.hotel.repositories.EstacionamentoRepository;
import com.fabiozanela.hotel.repositories.QuartoRepository;
import com.fabiozanela.hotel.repositories.ReservaRepository;
import com.fabiozanela.hotel.repositories.VeiculoRepository;
import com.fabiozanela.hotel.services.exceptions.ObjectConflict;

@Service
public class ReservaService {

	@Autowired
	private ReservaRepository reservaRepository;

	@Autowired
	private AgendaRepository agendaRepository;

	@Autowired
	private QuartoRepository quartoRepository;

	@Autowired
	private EstacionamentoRepository estacionamentoRepository;

	@Autowired
	private VeiculoRepository veiculoRepository;

	public List<ReservaNewDTO> findAll() {
		return reservaRepository.findAll().stream().map(obj -> this.fromDTO(obj)).collect(Collectors.toList());

	}

	public Reserva insert(ReservaNewDTO objDTO) {
		

		if (this.eReservado(objDTO)) {

			Reserva reserva = new Reserva(objDTO.getId(), objDTO.getDataInicio(), objDTO.getDataFim(),
					objDTO.getObservacao(), objDTO.getNumeroAdultos(), objDTO.getNumeroCriancas(), objDTO.getCliente());

			reserva = reservaRepository.save(reserva);
			for (AgendaDTO agendaDTO : objDTO.getAgendas()) {
				Agenda agenda = new Agenda(null, agendaDTO.getDate(), agendaDTO.getEstado(), reserva);
				agendaRepository.save(agenda);
				for (VeiculoDTO veiculoDTO : agendaDTO.getVeiculos()) {
					Veiculo veiculo = new Veiculo(null, veiculoDTO.getPlaca(), veiculoDTO.getModelo(),
							veiculoDTO.getCor(), veiculoDTO.getAno(), agenda);
					veiculo = veiculoRepository.save(veiculo);
					agenda.getVeiculos().add(veiculo);
				}

				for (QuartoDTO quartoDTO : agendaDTO.getQuartos()) {
					Quarto quarto = quartoRepository.findById(quartoDTO.getId()).get();
					agenda.getQuartos().add(quarto);
				}

				for (EstacionamentoDTO estacionamentoDTO : agendaDTO.getEstacionamentos()) {
					Estacionamento estacionamento = estacionamentoRepository.findById(estacionamentoDTO.getId()).get();
					agenda.getEstacionamentos().add(estacionamento);
				}

				reserva.getAgendas().add(agenda);
			}

			return reservaRepository.save(reserva);
		}
		else {
			throw new ObjectConflict("Já existe reserva para este quarto");
		}

	}

	public Reserva toDTO(ReservaNewDTO objDTO) {
		Reserva reserva = new Reserva(objDTO.getId(), objDTO.getDataInicio(), objDTO.getDataFim(),
				objDTO.getObservacao(), objDTO.getNumeroAdultos(), objDTO.getNumeroCriancas(), objDTO.getCliente());

		for (AgendaDTO agendaDTO : objDTO.getAgendas()) {
			Agenda agenda = new Agenda(agendaDTO.getId(), agendaDTO.getDate(), agendaDTO.getEstado(), reserva);
			for (QuartoDTO quartoDTO : agendaDTO.getQuartos()) {
				Quarto quarto = quartoRepository.findById(quartoDTO.getId()).get();
				agenda.getQuartos().add(quarto);
			}
			for (EstacionamentoDTO estacionamentoDTO : agendaDTO.getEstacionamentos()) {
				Estacionamento estacionamento = estacionamentoRepository.findById(estacionamentoDTO.getId()).get();
				agenda.getEstacionamentos().add(estacionamento);
			}
			for (VeiculoDTO veiculoDTO : agendaDTO.getVeiculos()) {
				Veiculo veiculo = veiculoRepository.findById(veiculoDTO.getId()).get();
				agenda.getVeiculos().add(veiculo);
			}
			reserva.getAgendas().add(agenda);
		}
		return reserva;
	}

	public ReservaNewDTO fromDTO(Reserva obj) {
		ReservaNewDTO reserva = new ReservaNewDTO(obj);

		for (Agenda agenda : obj.getAgendas()) {
			AgendaDTO agendaDTO = new AgendaDTO(agenda);

			for (Quarto quarto : agenda.getQuartos()) {
				agendaDTO.getQuartos().add(new QuartoDTO(quarto));
			}

			for (Estacionamento estacionamento : agenda.getEstacionamentos()) {
				agendaDTO.getEstacionamentos().add(new EstacionamentoDTO(estacionamento));
			}

			for (Veiculo veiculo : agenda.getVeiculos()) {
				agendaDTO.getVeiculos().add(new VeiculoDTO(veiculo));
			}
			reserva.getAgendas().add(agendaDTO);
		}
		return reserva;
	}

	public boolean eReservado(ReservaNewDTO objDTO) {
		Calendar calendar = Calendar.getInstance();
		for (AgendaDTO agendaDTO : objDTO.getAgendas()) {
			List<Quarto> quartos = agendaDTO.getQuartos().stream()
					.map(obj -> new Quarto(obj.getId(), obj.getNome(), null, null)).collect(Collectors.toList());
			calendar.setTime(agendaDTO.getDate());
			calendar.set(Calendar.MILLISECOND, 0);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			calendar.add(Calendar.DATE, 1);
			agendaDTO.setDate(calendar.getTime());
			for (Quarto objQuarto : quartos) {
				List<Agenda> listAgenda = agendaRepository.findByDateAndQuartosIn(agendaDTO.getDate(), objQuarto);
				if (!listAgenda.isEmpty()) {
					return false;
				}
			}
		}
		return true;
	}
}
