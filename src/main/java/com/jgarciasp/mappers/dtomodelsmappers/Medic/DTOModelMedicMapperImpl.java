package com.jgarciasp.mappers.dtomodelsmappers.Medic;

import org.springframework.stereotype.Service;

import com.jgarciasp.DTOs.MedicDTO;
import com.jgarciasp.mappers.MapperUtil;
import com.jgarciasp.models.MedicModel;

@Service
public class DTOModelMedicMapperImpl implements DTOModelMedicMapper {

	@Override
	public MedicDTO map(MedicModel model) {
		return this.map(model, new MedicDTO());
	}

	@Override
	public MedicModel map(MedicDTO dto) {
		return this.map(dto, new MedicModel());
	}

	@Override
	public MedicModel map(MedicDTO src, MedicModel dest) {
		dest.setName(src.getName());
		dest.setEmail(src.getEmail());
		dest.setConsults(MapperUtil.retrieveConsults(src.getConsults()));
		return dest;
	}

	@Override
	public MedicDTO map(MedicModel src, MedicDTO dest) {
		dest.setId(src.getId());
		dest.setName(src.getName());
		dest.setEmail(src.getEmail());
		dest.setConsults(MapperUtil.collectConsultIDs(src.getConsults()));
		return dest;
	}

}
