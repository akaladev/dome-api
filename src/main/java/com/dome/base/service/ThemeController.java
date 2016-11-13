package com.dome.base.service;

import java.util.List;


import com.dome.base.model.Theme;
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

@Api(value = "Themes", basePath = "/theme",  produces = "application/json")

@RestController
public class ThemeController {


    @ApiOperation(value = "Find all stored themes")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "") })
    @RequestMapping(value = "/theme/findByList", method = GET)
    public ResponseEntity<List<Theme>>  getColor(){
        List<Theme> colors = BaseRepository.findList(Theme.class);
        return new ResponseEntity<List<Theme>>(colors, OK);
    }

    @ApiOperation(value = "add a theme with a given name.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "")
    })
    @RequestMapping(value = "/theme/", method = POST)
    public ResponseEntity<Void> createTheme(@RequestBody Theme model, UriComponentsBuilder ucBuilder) {
        BaseRepository.save(model, Theme.class);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, CREATED);
    }

}


 