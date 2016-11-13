package com.dome.base.service;

import java.util.List;

import com.dome.base.model.Instruction;
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

@Api(value = "instruction", basePath = "/instruction",  produces = "application/json")

@RestController
public class InstructionController {
    
    
    @ApiOperation(value = "find all instructions")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "") })
    @RequestMapping(value = "/instruction/findByList", method = GET)
    public ResponseEntity<List<Instruction>>  getInstruction(){
        List<Instruction> instructions = BaseRepository.findList(Instruction.class);
        return new ResponseEntity<List<Instruction>>(instructions, OK);
    }
    
    @ApiOperation(value = "add instruction")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "")
    })
    @RequestMapping(value = "/instruction/", method = POST)
    public ResponseEntity<Void> createSpecie(@RequestBody Instruction instruction, UriComponentsBuilder ucBuilder) {
        BaseRepository.save(instruction, Instruction.class);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, CREATED);
    }
    
}


 