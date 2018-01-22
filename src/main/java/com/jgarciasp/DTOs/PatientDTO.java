package com.jgarciasp.DTOs;

import java.io.Serializable;

import lombok.Data;

@Data
public class PatientDTO implements Serializable {

	private static final long serialVersionUID = -4583226050350082915L;

	public PatientDTO() {
		super();
	}
	
	public PatientDTO( Integer id, String name, String email ) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}
	
	private Integer id;
	
	private String name;
	
	private String email;
	
} // public class PatientDTO implements Serializable 
