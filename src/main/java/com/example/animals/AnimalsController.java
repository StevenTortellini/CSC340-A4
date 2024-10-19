package com.example.animals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalsController {

    @Autowired
    private AnimalsService service;

    /**
     * Get a list of all Animal in the database.
     * http://localhost:8080/Animals/all
     *
     * @return a list of Animal  objects.
     */
    @GetMapping("/all")
    public List<Animal> getAllAnimals() {
        return service.getAllAnimals();
    }

    /**
     * Get a list of all Animal with specified species in the database.
     * http://localhost:8080/Animals?species=bird
     *
     * @return a list of Animal  objects.
     */
   /* @GetMapping("")  //<--------- next two methods causing a mapping error with the controller
    public List<Animal> getAnimalsBySpecies(@RequestParam(name = "species", defaultValue = "bird") String species) {

        return service.getAnimalsBySpecies(species);
    }
    /**
     * Get a list of all Animal with substring in name in the database.
     * http://localhost:8080/Animals?name=blue
     *
     * @return a list of Animal  objects.
     */
   /* @GetMapping("")
    public List<Animal> getAnimalsByName(@RequestParam(name = "name", defaultValue = "") String substring) {

        return service.getAnimalsBySubstring(substring);
    }

    /**
     * Get a specific Animal by Id.
     * http://localhost:8080/animals/2
     *
     * @param animalId the unique Id for an animal .
     * @return One animal object.
     */
    @GetMapping("/{animalId}")
    public Animal getOneAnimal(@PathVariable int animalId) {
        return service.getAnimalById(animalId);
    }

    /**
     * Create a new Student entry.
     * http://localhost:8080/animals/new --data '{ "AnimalId": 4, "name": "fox", "scientificName": "fox", "species": "fox","habitat": "woods", "description": ""}'
     *
     * @param animal the new Animal object.
     * @return the updated list of Animal.
     */
    @PostMapping("/new")
    public List<Animal> addNewAnimal(@RequestBody Animal animal) {
        service.addNewAnimal(animal);
        return service.getAllAnimals();
    }

    /**
     * Update an existing Animal object.
     * http://localhost:8080/animals/update/2 --data '{ "AnimalId": 4, "name": "fox", "scientificName": "fox", "species": "fox","habitat": "woods", "description": ""}'
     *
     * @param animalId the unique Student Id.
     * @param animal   the new update Animal details.
     * @return the updated Animal object.
     */
    @PutMapping("/update/{studentId}")
    public Animal updateAnimal(@PathVariable int animalId, @RequestBody Animal animal) {
        service.updateAnimal(animalId, animal);
        return service.getAnimalById(animalId);
    }

    /**
     * Delete a Student object.
     * http://localhost:8080/animals/delete/2
     *
     * @param animalId the unique Animal Id.
     * @return the updated list of Animal.
     */
    @DeleteMapping("/delete/{animalId}")
    public List<Animal> deleteStudentById(@PathVariable int animalId) {
        service.deleteAnimalById(animalId);
        return service.getAllAnimals();
    }

}

