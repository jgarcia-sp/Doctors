package com.jgarciasp.DTOs;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class PatientDTO implements Serializable {

	private static final long serialVersionUID = -4583226050350082915L;

	public PatientDTO() {
		super();
	}
	
	public PatientDTO( Integer id, String name, String email, List<Integer> appointments ) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.appointments = appointments;
	}
	
	private Integer id;
	
	private String name;
	
	private String email;
	
	private List<Integer> appointments;
	
} // public class PatientDTO implements Serializable 
