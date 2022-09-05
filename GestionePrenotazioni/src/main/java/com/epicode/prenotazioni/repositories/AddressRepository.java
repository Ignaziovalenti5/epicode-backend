package com.epicode.prenotazioni.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epicode.prenotazioni.models.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {

}
