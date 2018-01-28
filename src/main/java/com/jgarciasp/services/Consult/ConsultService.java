package com.jgarciasp.services.Consult;

import java.util.List;

import com.jgarciasp.DTOs.ConsultDTO;
import com.jgarciasp.models.ConsultModel;

public interface ConsultService {

	public List<ConsultDTO> findAll();

	public List<ConsultDTO> findAll(  Integer page, Integer size );

	public ConsultDTO findById ( Integer consultId );

	public ConsultModel findModelById ( Integer consultId );

	public ConsultDTO create ( ConsultDTO consult );

	public void update ( Integer consultId, ConsultDTO consult );

	public void delete ( Integer consultId );

} // public class ConsultService 
