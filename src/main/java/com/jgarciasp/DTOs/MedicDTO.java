package com.jgarciasp.DTOs;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class MedicDTO implements Serializable {

	private static final long serialVersionUID = -4006073956951422065L;

	private Integer id;
	
	private String name;
	
	private String email;
	
	private List<Integer> consults;
	
	public MedicDTO () {
		super();
		this.consults = new ArrayList<>();
	}
	
	public MedicDTO ( Integer id, String name, String email, List<Integer> consults ) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.consults = consults;
	}
	
} // public class MedicDTO implements Serializable 
