package com.jgarciasp.DAOs;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.jgarciasp.models.DoctorPriceModel;

@Repository
public interface DoctorPriceDAO extends PagingAndSortingRepository <DoctorPriceModel, Integer> {

} // public class DoctorPriceDAO extends PagingAndSortingRepository <DoctorPriceModel, Integer> 
