package com.jgarciasp.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Data
@Table(name="Appointment")
public class AppointmentModel implements Serializable {

	private static final long serialVersionUID = 6585590000135378197L;
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@JsonFormat
    (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private Date date;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private PatientModel patient;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private ConsultModel consult;
	
	public AppointmentModel () {
		super();
	}
	
	public AppointmentModel ( Integer id, PatientModel patient ) {
		
		super ();
		this.id = id;
		this.patient = patient;
		
	}

} // public class AppointmentModel implements Serializable
