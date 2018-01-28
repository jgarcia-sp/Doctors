package com.jgarciasp.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="Medic")
public class MedicModel implements Serializable {
	
	private static final long serialVersionUID = -8266711506784402047L;

	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	
	private String email;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "medic")
	private List<ConsultModel> consults;
	
	public MedicModel () {
		super();
		this.consults = new ArrayList<>();
	}
	
} // public class MedicModel implements Serializable 
