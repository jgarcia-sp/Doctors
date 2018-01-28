package com.jgarciasp.services.Medic;

import java.util.List;

import com.jgarciasp.DTOs.MedicDTO;
import com.jgarciasp.models.MedicModel;

public interface MedicService {

	public List<MedicDTO> findAll();

	public List<MedicDTO> findAll(  Integer page, Integer size );

	public MedicDTO findById ( Integer medicId );

	public MedicModel findModelById ( Integer medicId );

	public MedicDTO create ( MedicDTO medic );

	public void update ( Integer medicId, MedicDTO medic );

	public void delete ( Integer medicId );

} // public interface MedicService 
