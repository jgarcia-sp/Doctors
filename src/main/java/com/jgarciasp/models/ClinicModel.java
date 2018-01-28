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
@Table(name="Clinic")
public class ClinicModel implements Serializable {

	private static final long serialVersionUID = 3403732708990065130L;

	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "clinic")
	private List<RoomModel> rooms = new ArrayList<>();
	
	public ClinicModel () {
		super();
		this.rooms = new ArrayList<>();
	}
	
} // public class ClinicModel implements Serializable 
