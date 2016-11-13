package com.dome.base.service;

import java.util.List;

import com.dome.base.application.Application;
import com.dome.base.application.exception.ComponentNotFoundException;
import com.dome.base.model.*;
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
import org.hibernate.Hibernate;
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
    public ResponseEntity<Void> createAnimal(@RequestBody AnimalFacade facade, UriComponentsBuilder ucBuilder) {

       Color color= (Color) BaseRepository.find(Color.class, facade.getColorId());
       Specie specie= (Specie) BaseRepository.find(Specie.class, facade.getSpecieId());
       NationalStatus nstatus = (NationalStatus) BaseRepository.find(NationalStatus.class,facade.getNationId());
       ProvincialStatus pstatus = (ProvincialStatus) BaseRepository.find(ProvincialStatus.class, facade.getNationId());
       Animal model =new  Animal();
       model.setName(facade.getName());
       model.setColor(color);
       model.setScientificName(facade.getScientificName());
       model.setDescription(facade.getDescription());
       model.setImage(facade.getImage());
       model.setImageGeo(facade.getImageGeo());
       model.setNationalStatus(nstatus);
       model.setProvincialStatus(pstatus);
       model.setSpecie(specie);
       BaseRepository.save(model, Animal.class);
       HttpHeaders headers = new HttpHeaders();
       return new ResponseEntity<Void>(headers, CREATED);
    }
    
}


 