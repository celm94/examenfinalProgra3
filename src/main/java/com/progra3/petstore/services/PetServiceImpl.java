package com.progra3.petstore.services;

import com.progra3.petstore.dao.PetDao;
import com.progra3.petstore.entities.Pet;
import com.progra3.petstore.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetServiceImpl implements PetService{

    @Autowired
    PetDao petDao;


    @Override
    public List<Pet> listAll() {
        return (List<Pet>) petDao.findAll();
    }

    @Override
    public Pet findById(Long id) {
        Optional<Pet> opPet = petDao.findById(id);

        if(opPet.isPresent()) {
            return opPet.get();

        }else {

            throw new NotFoundException("Mascota no existe");
        }
    }

    @Override
    public void createPet(Pet pet) {
        petDao.save(pet);
    }

    @Override
    public void updatePet(Long id, Pet pet) {
        if(petDao.existsById(id)) {
            pet.setId(id);
            petDao.save(pet);
        }else {

            throw new NotFoundException("Mascota no encontrado");
        }


    }

    @Override
    public void deletePet(Long id) {
        if(petDao.existsById(id)) {
            petDao.deleteById(id);

        }else {

            throw new NotFoundException("Mascota no existe");
        }


    }
}
