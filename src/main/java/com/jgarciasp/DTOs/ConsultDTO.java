package com.jgarciasp.DTOs;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class ConsultDTO implements Serializable {

	private static final long serialVersionUID = -3166092553113805526L;
	
	private Integer id;
	
	private Date date;
	
	private String medic;
	
	private Integer room;
	
	private List<Integer> appointments;
	
	public ConsultDTO () {
		super();
		this.appointments = new ArrayList<>();
	}
	
	public ConsultDTO ( Integer id, Date date, String medic, Integer room, List<Integer> appointments ) {
		super();
		this.id = id;
		this.date = date;
		this.medic = medic;
		this.room = room;
		this.appointments = appointments;
	}

} // public class ConsultDTO implements Serializable
