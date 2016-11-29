package com.dome.base.service;

import java.util.List;


import com.dome.base.model.QRCode;
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

@Api(value = "QRCode", basePath = "/qrcode",  produces = "application/json")

@RestController
public class QRCodeController {


    @ApiOperation(value = "Find all stored qrcodes")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "") })
    @RequestMapping(value = "/qrcode/findByList", method = GET)
    public ResponseEntity<List<QRCode>>  getQRCode(){
        List<QRCode> colors = BaseRepository.findList(QRCode.class);
        return new ResponseEntity<List<QRCode>>(colors, OK);
    }

    @ApiOperation(value = "add a qrcode with a given name.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = ""),
            @ApiResponse(code = 404, message = "If the task with this id, doesn't exist")
    })
    @RequestMapping(value = "/qrcode/{id}", method = GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<QRCode> createQRCode(@PathVariable("id") long id) {
        QRCode qrcode = new QRCode();
        qrcode.setAnimalId(id);
        BaseRepository.save(qrcode, QRCode.class);
        return new ResponseEntity<QRCode>(qrcode, OK);

    }





}


 