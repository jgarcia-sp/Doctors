package com.jgarciasp.services.Clinic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.jgarciasp.DAOs.ClinicDAO;
import com.jgarciasp.DTOs.ClinicDTO;
import com.jgarciasp.mappers.dtomodelsmappers.Clinic.DTOModelClinicMapper;
import com.jgarciasp.models.ClinicModel;
import com.jgarciasp.models.RoomModel;
import com.jgarciasp.services.UtilService;
import com.jgarciasp.services.Room.RoomService;

@Service
public class ClinicServiceImpl implements ClinicService {

	public static final Integer ID_NOT_FOUND = 1;
	
	public static boolean isDefaultClinic ( ClinicModel clinic ) {
		return clinic.getId() == ClinicServiceImpl.ID_NOT_FOUND;
	}
	
	@Autowired
	private ClinicDAO clinicDAO;
	
	@Autowired
	private UtilService utilService;
	
	@Autowired
	private DTOModelClinicMapper clinicMapper;
	
	@Autowired
	private RoomService roomService;
	
	@Override
	public List<ClinicDTO> findAll() {
		List<ClinicDTO> result = new ArrayList<>();
		this.clinicDAO.findAll().forEach( (p) -> result.add(this.clinicMapper.map(p)));
		return result;
	}
	
	@Override
	public List<ClinicDTO> findAll( Integer page, Integer size ) {
		List<ClinicDTO> result = new ArrayList<>();
		this.clinicDAO.findAll().forEach( (p) -> result.add(this.clinicMapper.map(p)));
		return result;
	}
	
	@Override
	public ClinicDTO findById ( Integer clinicId ) {
		return this.clinicMapper.map(this.findModelById(clinicId));
	}

	@Override
	public ClinicModel findModelById ( Integer clinicId ) {
		
		if ( !this.clinicDAO.exists(clinicId) ) {
			clinicId = ClinicServiceImpl.ID_NOT_FOUND;
		} // if ( !this.clinicDAO.exists(clinicId) ) 
		return this.clinicDAO.findOne(clinicId);
		
	}
	
	@Override
	public ClinicDTO create(ClinicDTO clinic) {
		return this.clinicMapper.map(this.clinicDAO.save(this.clinicMapper.map(clinic, new ClinicModel())));
	}

	@Override
	public void update( Integer clinicId, ClinicDTO clinic) {
		ClinicModel existingClinic = this.clinicDAO.findOne(clinic.getId());
		this.utilService.copyNonNullProperties(this.clinicMapper.map(clinic), existingClinic);
		this.clinicDAO.save(existingClinic);
	}

	@Override
	public void delete(Integer clinicId) {
		this.deleteClinicRooms(clinicId);
		this.clinicDAO.delete(clinicId);
	}
	
	private void deleteClinicRooms ( Integer clinicId ) {
		final ClinicModel clinic = this.clinicDAO.findOne(clinicId);
		for ( RoomModel room : clinic.getRooms() ) {
			this.roomService.delete(room.getId());
		}
	}
	
} // public class ClinicServiceImpl implements ClinicService
