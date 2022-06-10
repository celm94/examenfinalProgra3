package com.progra3.petstore.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.progra3.petstore.entities.Pet;
import com.progra3.petstore.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/pets")
public class PetController {

	@Autowired
	PetService service;
	
	@GetMapping
	public List<Pet> findAll(){
		return service.listAll();
	}

	@GetMapping(value = "{id}")
	public Pet findPet(@PathVariable Long id) {
		return service.findById(id);
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping
	public void createPet(@Valid @RequestBody Pet pet) {
		
	service.createPet(pet); }

	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void updatePet(@PathVariable Long id, @RequestBody Pet pet) {
		service.updatePet(id, pet);


	}
	@DeleteMapping(value="{id}")
	public void deletePet(@PathVariable Long id) {
		service.deletePet(id);
	}

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(
			MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}

}
