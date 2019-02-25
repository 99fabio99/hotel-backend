package com.fabiozanela.hotel.services.exceptions;

public class ObjectConflict extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ObjectConflict(String msg) {
		super(msg);
	}
	
	public ObjectConflict(String msg, Throwable cause) {
		super(msg, cause);
	}

}
