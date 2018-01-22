package com.jgarciasp.DAOs;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.jgarciasp.models.PatientModel;

@Repository
public interface PatientDAO extends PagingAndSortingRepository <PatientModel, Integer> {
	
	public List<PatientModel> findAll();
	
	public PatientModel findById( Integer id );
	
//	public Patient create ( Patient patient );
	
} // public interface PatientDAO extends PagingAndSortingRepository <Patient, Integer> 
