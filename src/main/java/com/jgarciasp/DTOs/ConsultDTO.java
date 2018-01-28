package com.jgarciasp.DTOs;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ConsultDTO implements Serializable {

	private static final long serialVersionUID = -3166092553113805526L;
	
	private Integer id;
	
	private List<Integer> appointments;
	
	public ConsultDTO () {
		super();
		this.appointments = new ArrayList<>();
	}
	
	public ConsultDTO ( Integer id, List<Integer> appointments ) {
		super();
		this.id = id;
		this.appointments = appointments;
	}

} // public class ConsultDTO implements Serializable
