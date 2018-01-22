package com.jgarciasp.DAOs;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.jgarciasp.models.PatientModel;

@Repository
public interface PatientDAO extends PagingAndSortingRepository <PatientModel, Integer> {
	
} // public interface PatientDAO extends PagingAndSortingRepository <Patient, Integer> 
