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
		this.patient_id = id;
		this.patient_name = name;
		this.patient_email = email;
	}
	
	private Integer patient_id;
	
	private String patient_name;
	
	private String patient_email;
	
} // public class PatientDTO implements Serializable 
