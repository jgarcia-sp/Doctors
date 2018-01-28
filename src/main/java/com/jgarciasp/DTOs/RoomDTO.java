package com.jgarciasp.DTOs;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class RoomDTO implements Serializable {

	private static final long serialVersionUID = -2511788541506784194L;

	private Integer id;
	
	private String roomName;
	
	private Integer clinic;
	
	private List<Integer> consults;
	
	public RoomDTO () {
		super();
		this.consults = new ArrayList<>();
	}
	
	public RoomDTO ( Integer id, String roomName, Integer clinic, List<Integer> consults ) {
		super();
		this.id = id;
		this.roomName = roomName;
		this.clinic = clinic;
		this.consults = consults;
	} // public RoomDTO ( Integer id, String roomName, List<Integer> consults )
	
} // public class RoomDTO implements Serializable 
