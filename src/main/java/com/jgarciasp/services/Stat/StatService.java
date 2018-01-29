package com.jgarciasp.services.Stat;

import java.util.List;

import com.jgarciasp.DTOs.StatDTO;

public interface StatService {
	
	public List<StatDTO> findAll();
	
	public List<StatDTO> findAll(  Integer page, Integer size );
	
	public StatDTO findById ( Integer statId );
	
}
