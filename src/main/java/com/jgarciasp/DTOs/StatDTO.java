package com.jgarciasp.DTOs;

import java.io.Serializable;

import lombok.Data;

@Data
public class StatDTO implements Serializable {

	private static final long serialVersionUID = -4351459046269522306L;

	private String id;
	
	private String name;
	
	private float price;
	
} // public class StatDTO implements Serializable 
