package com.jgarciasp.DTOs;

import java.io.Serializable;

import lombok.Data;

@Data
public class AppointmentDTO implements Serializable {

	private static final long serialVersionUID = 8997192786411882834L;
	
	private Integer id;
	
	private Integer patient;
	
	public AppointmentDTO () {
		super();
	}
	
	public AppointmentDTO ( Integer id, Integer patient ) {
		super();
		this.id = id;
		this.patient = patient;
	}

}
