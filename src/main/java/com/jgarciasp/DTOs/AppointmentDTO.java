package com.jgarciasp.DTOs;

import java.io.Serializable;

import lombok.Data;

@Data
public class AppointmentDTO implements Serializable {

	private static final long serialVersionUID = 8997192786411882834L;
	
	private Integer id;
	
	private Integer patient;
	
	private Integer consult;
	
	public AppointmentDTO () {
		super();
	}
	
	public AppointmentDTO ( Integer id, Integer patient, Integer consult ) {
		super();
		this.id = id;
		this.patient = patient;
		this.consult = consult;
	}

} // public class AppointmentDTO implements Serializable
