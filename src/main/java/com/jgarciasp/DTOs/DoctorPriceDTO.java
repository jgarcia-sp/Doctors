package com.jgarciasp.DTOs;

import java.io.Serializable;

import lombok.Data;

@Data
public class DoctorPriceDTO implements Serializable {

	private static final long serialVersionUID = -6871493110511780806L;
	
	private String id;
	
	private String name;
	
	private float price;
	
	public DoctorPriceDTO () {
		super();
	}
	
	public DoctorPriceDTO ( String id, String name, float price ) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

} // public class DoctorPriceDTO implements Serializable 
