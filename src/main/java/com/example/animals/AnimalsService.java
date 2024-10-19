package com.example.animals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AnimalsService {
@Autowired
private  AnimalRepository animalRepository;

    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }


    public List<Animal> getAnimalsBySpecies(String species) {
    return animalRepository.getAnimalsBySpecies(species);
    }


    public List<Animal> getAnimalsBySubstring(String substring) {
    return animalRepository.getAnimalByName(substring);
    }


    public Animal getAnimalById(int animalId) {
    return animalRepository.findById(animalId).orElse(null);
    }

    public void addNewAnimal(Animal animal) {
         animalRepository.save(animal);

    }

    public void updateAnimal(int animalId, Animal animal) {
    Animal existing = getAnimalById(animalId);
    existing.setAnimalId(animal.getAnimalId());
    existing.setDescription(animal.getDescription());
    existing.setHabitat(animal.getHabitat());
    existing.setName(animal.getName());
    existing.setSpecies(animal.getSpecies());
    existing.setScientificName(animal.getScientificName());
    animalRepository.save(existing);
    }

    public void deleteAnimalById(int animalId) {
        animalRepository.deleteById(animalId);
    }
}
