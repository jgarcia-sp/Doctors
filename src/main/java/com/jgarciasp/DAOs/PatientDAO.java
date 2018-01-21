package com.jgarciasp.DAOs;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.jgarciasp.models.Patient;

@Repository
public interface PatientDAO extends PagingAndSortingRepository <Patient, Integer> {
	
} // public interface PatientDAO extends PagingAndSortingRepository <Patient, Integer> 
