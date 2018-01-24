package com.jgarciasp.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="Appointment")
public class AppointmentModel implements Serializable {

	private static final long serialVersionUID = 6585590000135378197L;
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private PatientModel patient;

} // public class AppointmentModel implements Serializable
