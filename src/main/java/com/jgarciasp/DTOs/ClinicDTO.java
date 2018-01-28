package com.jgarciasp.DTOs;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ClinicDTO implements Serializable {

	private static final long serialVersionUID = 8425436357224373033L;
	
	private Integer id;
	
	private String name;
	
	private List<Integer> rooms;
	
	public ClinicDTO () {
		super();
		this.rooms = new ArrayList<>();
	}
	
	public ClinicDTO ( Integer id, String name, List<Integer> rooms ) {
		super();
		this.id = id;
		this.name = name;
		this.rooms = rooms;
	} // public ClinicDTO ( Integer id, String name, List<Integer> rooms ) 

} // public class ClinicDTO implements Serializable 
