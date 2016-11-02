package com.dome.base.service;

import java.util.List;

import com.dome.base.application.Application;
import com.dome.base.application.exception.ComponentNotFoundException;
import com.dome.base.model.Specie;
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

@Api(value = "Species", basePath = "/specie",  produces = "application/json")

@RestController
public class SpecieController {
    
    
    @ApiOperation(value = "find all species")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "") })
    @RequestMapping(value = "/specie/findByList", method = GET)
    public ResponseEntity<List<Specie>>  getSpecies(){
        List<Specie> species = BaseRepository.findList(Specie.class);
        return new ResponseEntity<List<Specie>>(species, OK);
    }
    
    @ApiOperation(value = "add specie")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "")
    })
    @RequestMapping(value = "/specie/", method = POST)
    public ResponseEntity<Void> createSpecie(@RequestBody Specie specie, UriComponentsBuilder ucBuilder) {
        BaseRepository.save(specie, Specie.class);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, CREATED);
    }
    
}


 