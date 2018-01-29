package com.jgarciasp.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="DoctorPrice")
public class DoctorPriceModel implements Serializable {

	private static final long serialVersionUID = 2330300234247680800L;
	
	@Id
	@Column(length = 100)
	private String id;
	
	private String name;
	
	private float price;
	
} // public class DoctorPriceModel implements Serializable 
