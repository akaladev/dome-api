package com.dome.base.service;

import java.util.List;

import com.dome.base.bindings.ColorDao;
import com.dome.base.application.Application;
import com.dome.base.application.exception.ComponentNotFoundException;
import com.dome.base.model.Color;

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

@Api(value = "Colors", basePath = "/color", description = "Create and Get Colors Added", produces = "application/json")

@RestController
public class ColorController {
    
    
    @ApiOperation(value = "Find all stored colors")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "") })
    @RequestMapping(value = "/color/findByList", method = GET)
    public ResponseEntity<List<Color>>  getColor(){
     try {
          Application application = new Application();
          ColorDao dao = (ColorDao) application.getComponent("colorDaoImpl");
          List<Color> colors = dao.findByList();
          return new ResponseEntity<List<Color>>(colors, OK);
     }catch(ComponentNotFoundException exp){
            exp.printStackTrace();
        }
        return null;
    }
    
    @ApiOperation(value = "add a color with a given name.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "")
    })
    @RequestMapping(value = "/color/", method = POST)
    public ResponseEntity<Void> createColor(@RequestBody Color color, UriComponentsBuilder ucBuilder) {
        try {
          Application application = new Application();
          ColorDao dao = (ColorDao) application.getComponent("colorDaoImpl");
          dao.save(color);
          HttpHeaders headers = new HttpHeaders();
     }catch(ComponentNotFoundException exp){
            exp.printStackTrace();
        }
        return null;        
    }
    
}


 