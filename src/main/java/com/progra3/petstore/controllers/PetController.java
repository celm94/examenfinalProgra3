package com.progra3.petstore.controllers;

import java.util.List;

import com.progra3.petstore.entities.Pet;
import com.progra3.petstore.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/pets")
public class PetController {

	@Autowired
	PetService service;
	
	public List<Pet> findAll(){
		return service.listAll();
	}
	
	public Pet findPet(Long id) {
		return service.findById(id);
	}
	
	public Pet createPet(Pet pet) {
		
	return null; }
	
	public Pet updatePet(Long id, Pet pet) {
		return null;
	}
	
	public void deletePet(Long id) {
		//return service.deletePet(id);
	}

}
