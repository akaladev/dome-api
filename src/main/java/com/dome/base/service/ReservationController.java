package com.dome.base.service;

import java.util.List;
import com.dome.base.application.Application;
import com.dome.base.application.exception.ComponentNotFoundException;
import com.dome.base.model.Reservation;
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

@Api(value = "Reservation", basePath = "/reservation",  produces = "application/json")

@RestController
public class ReservationController {
    
    
    @ApiOperation(value = "Find all booked reservations")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "") })
    @RequestMapping(value = "/reservation/findByList", method = GET)
    public ResponseEntity<List<Reservation>>  getReservation(){
        List<Reservation> reservations = BaseRepository.findList(Reservation.class);
        return new ResponseEntity<List<Reservation>>(reservations, OK);
    }
    
    @ApiOperation(value = "add reservation")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "")
    })
    @RequestMapping(value = "/reservation/", method = POST)
    public ResponseEntity<Void> createColor(@RequestBody Reservation reservation, UriComponentsBuilder ucBuilder) {
        BaseRepository.save(reservation, Reservation.class);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, CREATED);
    }
    
}


 