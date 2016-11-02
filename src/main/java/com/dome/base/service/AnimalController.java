package com.dome.base.service;

import java.util.List;

import com.dome.base.application.Application;
import com.dome.base.application.exception.ComponentNotFoundException;
import com.dome.base.model.Animal;
import com.dome.base.repository.BaseRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@Api(value = "animal", basePath = "/animal",  produces = "application/json")

@RestController
public class AnimalController {
    
    
    @ApiOperation(value = "find all animals")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "") })
    @RequestMapping(value = "/animal/findByList", method = GET)
    public ResponseEntity<List<Animal>>  getAnimals(){
        List<Animal> animals = BaseRepository.findList(Animal.class);
        return new ResponseEntity<List<Animal>>(animals, OK);
    }
    
    @ApiOperation(value = "add instruction")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "")
    })
    @RequestMapping(value = "/animal/", method = POST)
    public ResponseEntity<Void> createAnimal(@RequestBody Animal animal, UriComponentsBuilder ucBuilder) {
        BaseRepository.save(animal, Animal.class);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, CREATED);
    }
    
}


 