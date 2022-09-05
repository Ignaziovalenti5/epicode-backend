package com.epicode.prenotazioni.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epicode.prenotazioni.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
