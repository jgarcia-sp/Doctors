package com.jgarciasp.DTOs;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class ConsultDTO implements Serializable {

	private static final long serialVersionUID = -3166092553113805526L;
	
	public ConsultDTO () {
		super();
	}
	
	public ConsultDTO ( Integer id, List<Integer> appointments ) {
		super();
		this.id = id;
		this.appointments = appointments;
	}
	
	private Integer id;
	
	private List<Integer> appointments;

} // public class ConsultDTO implements Serializable
