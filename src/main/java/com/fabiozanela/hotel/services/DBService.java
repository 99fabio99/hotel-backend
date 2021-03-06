package com.fabiozanela.hotel.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabiozanela.hotel.domain.Agenda;
import com.fabiozanela.hotel.domain.Caracteristica;
import com.fabiozanela.hotel.domain.Categoria;
import com.fabiozanela.hotel.domain.Cliente;
import com.fabiozanela.hotel.domain.Empresa;
import com.fabiozanela.hotel.domain.Endereco;
import com.fabiozanela.hotel.domain.Estacionamento;
import com.fabiozanela.hotel.domain.Item;
import com.fabiozanela.hotel.domain.ItemConsumido;
import com.fabiozanela.hotel.domain.Pagamento;
import com.fabiozanela.hotel.domain.PagamentoComCartao;
import com.fabiozanela.hotel.domain.PagamentoComDinheiro;
import com.fabiozanela.hotel.domain.PerfilQuarto;
import com.fabiozanela.hotel.domain.Quarto;
import com.fabiozanela.hotel.domain.Reserva;
import com.fabiozanela.hotel.domain.Veiculo;
import com.fabiozanela.hotel.domain.enums.EstadoPagamento;
import com.fabiozanela.hotel.domain.enums.EstadoQuarto;
import com.fabiozanela.hotel.domain.enums.TipoCliente;
import com.fabiozanela.hotel.repositories.AgendaRepository;
import com.fabiozanela.hotel.repositories.CaracteristicaRepository;
import com.fabiozanela.hotel.repositories.CategoriaRepository;
import com.fabiozanela.hotel.repositories.ClienteRepository;
import com.fabiozanela.hotel.repositories.EmpresaRepository;
import com.fabiozanela.hotel.repositories.EnderecoRepository;
import com.fabiozanela.hotel.repositories.EstacionamentoRepository;
import com.fabiozanela.hotel.repositories.ItemConsumidoRepository;
import com.fabiozanela.hotel.repositories.ItemRepository;
import com.fabiozanela.hotel.repositories.PagamentoRepository;
import com.fabiozanela.hotel.repositories.PerfilQuartoRepository;
import com.fabiozanela.hotel.repositories.QuartoRepository;
import com.fabiozanela.hotel.repositories.ReservaRepository;
import com.fabiozanela.hotel.repositories.VeiculoRepository;

@Service
public class DBService {
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private QuartoRepository quartoRepository;
	
	@Autowired
	private EstacionamentoRepository estacionamentoRepository;
	
	@Autowired
	private PerfilQuartoRepository perfilQuartoRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private CaracteristicaRepository caracteristicaRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ReservaRepository reservaRepository;
	
	@Autowired
	private AgendaRepository agendaRepository;
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ItemConsumidoRepository itemConsumidoRepository;
	
	public void instantiateTestDatebase() throws ParseException {
		
		Endereco end1 = new Endereco(null, "0", "0", "", "Aeroporto", "73840-000", "Campos Belos", "GO");
		Endereco end2 = new Endereco(null, "1", "1", "sadas", "Aeroporto", "73840-000", "Campos Belos", "GO");
		Endereco end3 = new Endereco(null, "2", "2", "dasdasdas", "Aeroporto", "73840-000", "Campos Belos", "GO");
		
		enderecoRepository.saveAll(Arrays.asList(end1,end2,end3));
		
		Empresa emp = new Empresa(null, "Serra verde",end1);
		
		emp.getTelefones().addAll(Arrays.asList("27363323","93838393"));
		
		empresaRepository.save(emp);
		
		PerfilQuarto per1 = new PerfilQuarto(null, "Simples", 100.0, 40.0, 10.0);
		PerfilQuarto per2 = new PerfilQuarto(null, "Luxo", 200.0, 40.0, 10.0);
		PerfilQuarto per3 = new PerfilQuarto(null, "Presidencial", 300.0, 40.0, 10.0);
		
		Caracteristica car1 = new Caracteristica(null,"Cama de solteiro");
		Caracteristica car2 = new Caracteristica(null,"Cama de casal");
		Caracteristica car3 = new Caracteristica(null,"Ar condicionado");
		Caracteristica car4 = new Caracteristica(null,"Ventilador");
		Caracteristica car5 = new Caracteristica(null,"TV");
		
		per1.getCaracteristicas().addAll(Arrays.asList(car1, car4, car5));
		per2.getCaracteristicas().addAll(Arrays.asList(car2, car3, car5));
		per3.getCaracteristicas().addAll(Arrays.asList(car1, car2, car4, car5));
		
		car1.getPerfilQuartos().addAll(Arrays.asList(per1,per3));
		car2.getPerfilQuartos().addAll(Arrays.asList(per2,per3));
		car3.getPerfilQuartos().addAll(Arrays.asList(per2,per3));
		car4.getPerfilQuartos().addAll(Arrays.asList(per1,per3));
		car5.getPerfilQuartos().addAll(Arrays.asList(per1, per2, per3));
		
		perfilQuartoRepository.saveAll(Arrays.asList(per1, per2, per3));
		
		caracteristicaRepository.saveAll(Arrays.asList(car1,car2,car3,car4,car5));
		
		Quarto qua1 = new Quarto(null,"01", emp, per1);
		Quarto qua2 = new Quarto(null,"02", emp, per1);
		Quarto qua3 = new Quarto(null,"03", emp, per2);
		Quarto qua4 = new Quarto(null,"04", emp, per2);
		Quarto qua5 = new Quarto(null,"05", emp, per3);
		Quarto qua6 = new Quarto(null,"06", emp, per3);
		
		Estacionamento est1 = new Estacionamento(null, "01", "A", emp);
		Estacionamento est2 = new Estacionamento(null, "02", "A", emp);
		Estacionamento est3 = new Estacionamento(null, "03", "A", emp);
		Estacionamento est4 = new Estacionamento(null, "04", "A", emp);
		
		emp.getQuartos().addAll(Arrays.asList(qua1,qua2,qua3,qua4,qua5,qua6));
		emp.getEstacionamentos().addAll(Arrays.asList(est1,est2,est3,est4));
		
		per1.getQuartos().addAll(Arrays.asList(qua1,qua2));
		per2.getQuartos().addAll(Arrays.asList(qua3,qua4));
		per3.getQuartos().addAll(Arrays.asList(qua5,qua6));
		
		quartoRepository.saveAll(Arrays.asList(qua1, qua2, qua3, qua4,qua5,qua6));
		estacionamentoRepository.saveAll(Arrays.asList(est1, est2, est3, est4));
		
		Categoria cat1 = new Categoria(null, "Refrigerante");
		Categoria cat2 = new Categoria(null, "Variados");
		Categoria cat3 = new Categoria(null, "Serviços");
		
		Item item1 = new Item(null, "Coca-cola 2l", 6.5, "9789563530766", 15, emp, cat1);
		Item item2 = new Item(null, "Agua 1l", 2.5, "9789563530766", 11, emp,cat2);
		Item item3 = new Item(null, "Nutella 350g", 20.0, "9789563530766", 5, emp,cat2);
		Item item4 = new Item(null, "Protetor solar", 30.5, "9789563530766", 10, emp,cat2);
		Item item5 = new Item(null, "Almoço 2", 25.3, "9789563530766", 1, emp,cat3);
		Item item6 = new Item(null, "Jantar 4", 35.0, "9789563530766", 10, emp,cat3);
		
		cat1.getItens().addAll(Arrays.asList(item1));
		cat2.getItens().addAll(Arrays.asList(item2, item3, item4));
		cat3.getItens().addAll(Arrays.asList(item3, item3));
		
		emp.getItens().addAll(Arrays.asList(item1,item2,item3,item4,item5, item6));
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		itemRepository.saveAll(Arrays.asList(item1,item2,item3,item4,item5,item6));
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Cliente cli1 = new Cliente(null, "Fabio Miranda Zanela", "99988877766", "fabio.fmz18@hotmail.com", sdf.parse("06/10/1995"), TipoCliente.PESSOAFISICA, end2);
		
		cli1.getTelefones().addAll(Arrays.asList("2312312312", "32131231231"));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		
		Reserva res1 = new Reserva(null, sdf.parse("21/02/2019"), sdf.parse("24/02/2019"), "Teseeeeeeeeeee", 2, 1, cli1);
		Reserva res2 = new Reserva(null, sdf.parse("21/02/2019"), sdf.parse("22/02/2019"), "Teseeeeeeeeeee", 1, 0, cli1);
		
		Pagamento pag1 = new PagamentoComDinheiro(null, EstadoPagamento.QUITADO, res1, 0.0);
		res1.setPagamento(pag1);
		
		Pagamento pag2 = new PagamentoComCartao(null, EstadoPagamento.PENDENTE, res2, 3, 0.0);
		res2.setPagamento(pag2);
		
		reservaRepository.saveAll(Arrays.asList(res1, res2));
		
		pagamentoRepository.saveAll(Arrays.asList(pag1, pag2));
		
		Agenda age1 = new Agenda(null, sdf.parse("21/02/2019"), EstadoQuarto.OCUPADO, res1);
		Agenda age2 = new Agenda(null, sdf.parse("22/02/2019"), EstadoQuarto.OCUPADO, res1);
		Agenda age3 = new Agenda(null, sdf.parse("23/02/2019"), EstadoQuarto.OCUPADO, res1);
		Agenda age4 = new Agenda(null, sdf.parse("24/02/2019"), EstadoQuarto.OCUPADO, res1);
		
		Agenda age5 = new Agenda(null, sdf.parse("21/02/2019"), EstadoQuarto.OCUPADO, res2);
		
		age1.getQuartos().add(qua1);
		age2.getQuartos().add(qua1);
		age3.getQuartos().add(qua1);
		age4.getQuartos().add(qua1);
		qua1.getAgendas().addAll(Arrays.asList(age1, age2, age3, age4));
		
		age5.getQuartos().add(qua2);
		qua2.getAgendas().add(age5);
		
		age1.getEstacionamentos().add(est1);
		age2.getEstacionamentos().add(est1);
		age3.getEstacionamentos().add(est1);
		age4.getEstacionamentos().add(est1);
		est1.getAgendas().addAll(Arrays.asList(age1, age2, age3, age4));
		
		age5.getEstacionamentos().add(est2);
		est2.getAgendas().add(age5);
		
		res1.getAgendas().addAll(Arrays.asList(age1, age2, age3, age4));
		res2.getAgendas().addAll(Arrays.asList(age5));
		
		agendaRepository.saveAll(Arrays.asList(age1, age2, age3, age4, age5));
		
		Veiculo vei1 = new Veiculo(null, "WAS-1234", "GOL", "Azul", 1995, age1);
		
		age1.getVeiculos().add(vei1);
		
		veiculoRepository.saveAll(Arrays.asList(vei1));
		
		
		ItemConsumido itemC1 = new ItemConsumido(res1, item1, 25.1, 3);
		ItemConsumido itemC2 = new ItemConsumido(res1, item2, 22.2, 1);
		ItemConsumido itemC3 = new ItemConsumido(res1, item3, 5.6, 1);
		ItemConsumido itemC4 = new ItemConsumido(res2, item1, 2.8, 4);
		
		res1.getItens().addAll(Arrays.asList(itemC1, itemC2, itemC3));
		res2.getItens().addAll(Arrays.asList(itemC4));
		
		item1.getItens().addAll(Arrays.asList(itemC1, itemC4));
		item2.getItens().addAll(Arrays.asList(itemC2));
		item3.getItens().addAll(Arrays.asList(itemC3));
		
		itemConsumidoRepository.saveAll(Arrays.asList(itemC1, itemC2, itemC3, itemC4));
		
		}

}
