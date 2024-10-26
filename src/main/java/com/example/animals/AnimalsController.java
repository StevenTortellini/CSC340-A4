package com.example.animals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;



@Controller
@RequestMapping("/animals")
public class AnimalsController {

    @Autowired
    private AnimalsService service;

    @GetMapping("/create")
    public String showCreateForm(){
        return  "animal.create";
    }
    /**
     * Get a list of all Animal in the database.
     * http://localhost:8080/Animals/all
     *
     * @return a list of Animal  objects.
     */
    @GetMapping("/all")
    public String getAllAnimals(Model model) {
        //return service.getAllAnimals();
        model.addAttribute("animalList", service.getAllAnimals());
        model.addAttribute("title","All Animals");
        return "animal-List";
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
    public String getOneAnimal(@PathVariable int animalId, Model model) {
        model.addAttribute("animal", service.getAnimalById(animalId));
        model.addAttribute("title",animalId);
        return "animal-details" ;

    }


    /**
     * Create a new Student entry.
     * http://localhost:8080/animals/new --data '{ "AnimalId": 4, "name": "fox", "scientificName": "fox", "species": "fox","habitat": "woods", "description": ""}'
     *
     * @param animal the new Animal object.
     * @return the updated list of Animal.
     */
    @PostMapping("/new")
    public String addNewAnimal(@RequestBody Animal animal) {
        service.addNewAnimal(animal);
        return "redirect:/students/all";
    }

    /**
     * Update an existing Animal object.
     * http://localhost:8080/animals/update/2 --data '{ "AnimalId": 4, "name": "fox", "scientificName": "fox", "species": "fox","habitat": "woods", "description": ""}'
     *
     * @param animalId the unique Student Id.
     *
     * @return the updated Animal object.
     */
    @GetMapping("/update/{studentId}")
    public String showUpdateForm(@PathVariable int animalId, Model model) {
        model.addAttribute("student",service.getAnimalById(animalId));
        return "animal-update";
    }

    /**
     * Perform the update.
     * @param animal
     * @return
     */
    @PostMapping("/update")
    public String updateStudent(Animal animal) {
        service.addNewAnimal(animal);
        return "redirect:/animals/" + animal.getAnimalId();
    }


    /**
     * Delete a animal object.
     * http://localhost:8080/animals/delete/2
     *
     * @param animalId the unique Animal Id.
     * @return the updated list of Animal.
     */
    @GetMapping("/delete/{animalId}")
    public String deleteStudentById(@PathVariable int animalId) {
        service.deleteAnimalById(animalId);
        return "redirect:/animals/all";
    }

}

