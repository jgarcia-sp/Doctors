package com.jgarciasp.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Patient implements Serializable {

	private static final long serialVersionUID = 1823974002962341154L;

	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	
} // public class Patient implements Serializable 
