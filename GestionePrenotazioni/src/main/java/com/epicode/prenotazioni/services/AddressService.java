package com.epicode.prenotazioni.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epicode.prenotazioni.models.Address;
import com.epicode.prenotazioni.repositories.AddressRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository repo;
	
	public List<Address> getAllAddress() {
		return (List<Address>) repo.findAll();
	}
	
	public Address findById(Long id) {
		return repo.findById(id).get();
	}
	
	public void deleteAddress(Long id) {
		repo.deleteById(id);
	}
	
	public void create(Address address) {
		repo.save(address);
	}
	
	public void edit(Address address) {
		repo.save(address);
	}
}
