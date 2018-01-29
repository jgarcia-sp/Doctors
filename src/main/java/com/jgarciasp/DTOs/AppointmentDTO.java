package com.jgarciasp.DTOs;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class AppointmentDTO implements Serializable {

	private static final long serialVersionUID = 8997192786411882834L;
	
	private Integer id;
	
	private Date date;
	
	private Integer patient;
	
	private Integer consult;
	
	public AppointmentDTO () {
		super();
	}
	
	public AppointmentDTO ( Integer id, Date date, Integer patient, Integer consult ) {
		super();
		this.id = id;
		this.date = date;
		this.patient = patient;
		this.consult = consult;
	}

} // public class AppointmentDTO implements Serializable
