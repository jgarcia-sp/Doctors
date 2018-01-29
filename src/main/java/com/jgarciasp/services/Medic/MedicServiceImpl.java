package com.jgarciasp.services.Medic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jgarciasp.DAOs.MedicDAO;
import com.jgarciasp.DTOs.MedicDTO;
import com.jgarciasp.mappers.dtomodelsmappers.Medic.DTOModelMedicMapper;
import com.jgarciasp.models.ConsultModel;
import com.jgarciasp.models.MedicModel;
import com.jgarciasp.services.UtilService;
import com.jgarciasp.services.Consult.ConsultService;
import com.jgarciasp.services.Medic.MedicServiceImpl;

@Service
public class MedicServiceImpl implements MedicService {

	public static final String ID_NOT_FOUND = "1";

	public static boolean isDefaultMedic ( MedicModel medic ) {
		return medic.getId() == MedicServiceImpl.ID_NOT_FOUND;
	}
	
	@Autowired
	private MedicDAO medicDAO;
	
	@Autowired
	private UtilService utilService;
	
	@Autowired
	private DTOModelMedicMapper medicMapper;
	
	@Autowired
	private ConsultService consultService;

	@Override
	public List<MedicDTO> findAll() {
		List<MedicDTO> result = new ArrayList<>();
		this.medicDAO.findAll().forEach( (p) -> result.add(this.medicMapper.map(p)));
		return result;
	}

	@Override
	public List<MedicDTO> findAll(Integer page, Integer size) {
		List<MedicDTO> result = new ArrayList<>();
		this.medicDAO.findAll().forEach( (p) -> result.add(this.medicMapper.map(p)));
		return result;
	}

	@Override
	public MedicDTO findById ( String medicId ) {
		return this.medicMapper.map(this.findModelById(medicId));
	}

	@Override
	public MedicModel findModelById ( String medicId ) {
		
		if ( !this.medicDAO.exists(medicId) ) {
			medicId = MedicServiceImpl.ID_NOT_FOUND;
		} // if ( !this.medicDAO.exists(medicId) ) 
		return this.medicDAO.findOne(medicId);
		
	}
	
	@Override
	public MedicDTO create(MedicDTO medic) {
		return this.medicMapper.map(this.medicDAO.save(this.medicMapper.map(medic, new MedicModel())));
	}

	@Override
	public void update( String medicId, MedicDTO medic) {
		MedicModel existingMedic = this.medicDAO.findOne(medic.getId());
		this.utilService.copyNonNullProperties(this.medicMapper.map(medic), existingMedic);
		this.medicDAO.save(existingMedic);
	}

	@Override
	public void delete(String medicId) {
		this.deleteMedicConsults(medicId);
		this.medicDAO.delete(medicId);
	}
	
	private void deleteMedicConsults ( String medicId ) {
		final MedicModel medic = this.medicDAO.findOne(medicId);
		for ( ConsultModel consult : medic.getConsults() ) {
			this.consultService.delete(consult.getId());
		}
	}

} // public class MedicServiceImpl implements MedicService 
