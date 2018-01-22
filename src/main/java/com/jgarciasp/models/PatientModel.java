package com.jgarciasp.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="Patient")
public class PatientModel implements Serializable {

	private static final long serialVersionUID = 1823974002962341154L;

	@Id
	@GeneratedValue
	private Integer patient_id;
	
	@Column(nullable = false)
	private String patient_name;
	
	@Column(unique = true)
	private String patient_email;
	
} // public class Patient implements Serializable 
