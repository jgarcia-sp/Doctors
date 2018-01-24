package com.jgarciasp.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Service;

// This class holds functionality common to all services

@Service
public class UtilService {

	/*
	 * 
	 * Copies only the non-empty fields from source object src into destination object target
	 * 
	 */
	
	public void copyNonNullProperties(Object src, Object target) {
	    BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
	}
	
	public String[] getNullPropertyNames (Object source) {
	    final BeanWrapper src = new BeanWrapperImpl(source);
	    java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();
	    return checkNullPropertyNames (src, pds);
	}
	
	private String [] checkNullPropertyNames ( BeanWrapper src, java.beans.PropertyDescriptor[] pds ) {
		Set<String> emptyNames = new HashSet<String>();
	    for(java.beans.PropertyDescriptor pd : pds) {
	        Object srcValue = src.getPropertyValue(pd.getName());
	        if (srcValue == null) emptyNames.add(pd.getName());
	    }
	    return collectPropertyNames ( emptyNames );
	}
	
	private String [] collectPropertyNames ( Set<String> names ) {
		String[] result = new String[names.size()];
	    return names.toArray(result);
	} 
}





