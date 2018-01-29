package com.jgarciasp.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="Patient")
public class PatientModel implements Serializable {

	private static final long serialVersionUID = 1823974002962341154L;

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(unique = true, length = 100)
	private String email;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
	private List<AppointmentModel> appointments = new ArrayList<>();
	
	public PatientModel () {
		super();
		this.appointments = new ArrayList<>();
	}
	
} // public class Patient implements Serializable 
