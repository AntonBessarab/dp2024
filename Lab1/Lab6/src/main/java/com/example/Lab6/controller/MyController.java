package com.example.Lab6.controller;

import com.example.Lab6.entity.Broniks;
import com.example.Lab6.repository.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

@RestController
@RequestMapping("/Lab6/api/my_entity")
public class MyController {

    @Autowired
    MyRepository myRepository;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Broniks postEntity(@RequestBody Broniks broniks) {
        return myRepository.save(broniks);
    }

    @GetMapping("/retrieve")
    public List<Broniks> getEntities() {
        return myRepository.findAll();
    }

    @PutMapping("/update/{id}")
    public Broniks putEntity(@PathVariable long id, @RequestBody Broniks newEntity) {
        Broniks updatedEntity = myRepository.findById(id)
                .orElseThrow(() -> new ResourceAccessException("Not found Broniks with id: " + id));
        updatedEntity.setName(newEntity.getName());
        updatedEntity.setDescription(newEntity.getDescription());
        updatedEntity.setImg(newEntity.getImg());
        return myRepository.save(updatedEntity);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEntity(@PathVariable long id) {
        if (!myRepository.existsById(id)) {
            throw new ResourceAccessException("Not found Broniks with id: " + id);
        }
        myRepository.deleteById(id);
    }
}
