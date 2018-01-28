package com.jgarciasp.mappers.dtomodelsmappers.Medic;

import com.jgarciasp.DTOs.MedicDTO;
import com.jgarciasp.models.MedicModel;

public interface DTOModelMedicMapper {

	public MedicDTO map ( MedicModel model );

	public MedicModel map ( MedicDTO dto );

	public MedicModel map ( MedicDTO src, MedicModel dest );

	public MedicDTO map ( MedicModel src, MedicDTO dest );

} // public class DTOModelMedicMapper 
