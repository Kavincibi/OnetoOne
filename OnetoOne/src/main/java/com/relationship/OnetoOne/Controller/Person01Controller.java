package com.relationship.OnetoOne.Controller;


import com.relationship.OnetoOne.Models.Person01;
import com.relationship.OnetoOne.Repository.Person01repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person01")
@CrossOrigin
public class Person01Controller {

   @Autowired
    public Person01repository repository;

   @GetMapping("/test")
   public String  test(){
       return "Test api works.....";
   }
   @GetMapping
    public List<Person01> getAllPerson01(){
       return repository.findAll();
   }
    @PostMapping
    public String insertPerson(@RequestBody Person01 person){
        repository.save(person);
        return "Person added.";
    }

    @PutMapping("/{id}")
    public String updatePerson(@PathVariable long id,@RequestBody Person01 person){
        Optional<Person01> person1 = repository.findById(id);
        if (person1.isPresent()) {
            person1.get().setName(person.getName());
            person1.get().setPassport01(person.getPassport01());
            repository.save(person1.get());
        }
        return "Person updated.";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id){
        repository.deleteById(id);
        return "person deleted.";
    }

}
