package com.dome.base.service;

import java.util.List;

import com.dome.base.bindings.ProvincialStatusDao;
import com.dome.base.application.Application;
import com.dome.base.application.exception.ComponentNotFoundException;
import com.dome.base.model.ProvincialStatus;

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

@Api(value = "Province", basePath = "/province", description = "Create and Get Provincial Statuses Added", produces = "application/json")

@RestController
public class ProvincialController {
    
    
    @ApiOperation(value = "Find all stored statuses")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "") })
    @RequestMapping(value = "/province/findByList", method = GET)
    public ResponseEntity<List<ProvincialStatus>>  getStatus(){
     try {
          Application application = new Application();
          ProvincialStatusDao dao = (ProvincialStatusDao) application.getComponent("pationalStatusDaoImpl");
          List<ProvincialStatus> statusList = dao.findByList();
          return new ResponseEntity<List<ProvincialStatus>>(statusList, OK);
     }catch(ComponentNotFoundException exp){
            exp.printStackTrace();
        }
        return null;
    }
    
    @ApiOperation(value = "add a given status.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "")
    })
    @RequestMapping(value = "/province/", method = POST)
    public ResponseEntity<Void> createStatus(@RequestBody ProvincialStatus status, UriComponentsBuilder ucBuilder) {
        try {
          Application application = new Application();
           ProvincialStatusDao dao = (ProvincialStatusDao) application.getComponent("pationalStatusDaoImpl");
          dao.save(status);
          HttpHeaders headers = new HttpHeaders();
     }catch(ComponentNotFoundException exp){
            exp.printStackTrace();
        }
        return null;        
    }
    
}


 