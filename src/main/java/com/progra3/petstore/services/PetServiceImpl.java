package com.progra3.petstore.services;

import com.progra3.petstore.dao.PetDao;
import com.progra3.petstore.entities.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceImpl implements PetService{

    @Autowired
    PetDao petDao;


    @Override
    public List<Pet> listAll() {
        return null;
    }

    @Override
    public Pet findById(Long id) {
        return null;
    }

    @Override
    public void createPet(Pet pet) {

    }

    @Override
    public Pet updatePet(Long id, Pet pet) {
        return null;
    }

    @Override
    public void deletePet(Long id) {

    }
}
