package com.jgarciasp.DAOs;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.jgarciasp.models.Patient;

@Repository
public interface PatientDAO extends PagingAndSortingRepository <Patient, Integer> {
	
	public List<Patient> findAll();
	
} // public interface PatientDAO extends PagingAndSortingRepository <Patient, Integer> 
