package com.jgarciasp.DAOs;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.jgarciasp.models.RoomModel;

@Repository
public interface RoomDAO extends PagingAndSortingRepository <RoomModel, Integer> {

} // public interface RoomDAO extends PagingAndSortingRepository <RoomModel, Integer> 
