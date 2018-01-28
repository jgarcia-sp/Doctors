package com.jgarciasp.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="Room")
public class RoomModel implements Serializable {

	private static final long serialVersionUID = -1064303454509297182L;
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String roomName;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private ClinicModel clinic;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "room")
	private List<ConsultModel> consults = new ArrayList<>();
	
	public RoomModel () {
		super();
		this.consults = new ArrayList<>();
	}

} // public class RoomModel implements Serializable 
