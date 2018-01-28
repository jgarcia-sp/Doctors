package com.jgarciasp.mappers.dtomodelsmappers.consult;

import com.jgarciasp.DTOs.ConsultDTO;
import com.jgarciasp.models.ConsultModel;

public interface DTOModelConsultMapper {

	public ConsultDTO map ( ConsultModel model );
	
	public ConsultModel map ( ConsultDTO dto );
	
	public ConsultDTO map ( ConsultModel src, ConsultDTO dest );
	
	public ConsultModel map ( ConsultDTO src, ConsultModel dest );
	
} // public interface DTOModelConsultMapper
