package com.jgarciasp.services.Medic;

import java.util.List;

import com.jgarciasp.DTOs.MedicDTO;
import com.jgarciasp.models.MedicModel;

public interface MedicService {

	public List<MedicDTO> findAll();

	public List<MedicDTO> findAll(  Integer page, Integer size );

	public MedicDTO findById ( String medicId );

	public MedicModel findModelById ( String medicId );

	public MedicDTO create ( MedicDTO medic );

	public void update ( String medicId, MedicDTO medic );

	public void delete ( String medicId );

} // public interface MedicService 
