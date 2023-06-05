package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.pojos.Address;
import com.app.repository.AddressRepository;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {
	@Autowired
	private AddressRepository adrRepo;

	@Override
	public Address getAddressDetails(long addressId) {
		// TODO Auto-generated method stub
		return adrRepo.findById(addressId).orElseThrow(() -> new ResourceNotFoundException("Invalid Address Id!!!!"));
	}

}
