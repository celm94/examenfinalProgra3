package com.progra3.petstore.dao;


import com.progra3.petstore.entities.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetDao extends CrudRepository<Pet, Long> {
}
