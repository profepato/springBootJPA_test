package com.example.jpa.controller;

import com.example.jpa.model.City;
import com.example.jpa.model.Client;
import com.example.jpa.model.Region;
import com.example.jpa.repository.CityRepository;
import com.example.jpa.repository.ClientRepository;
import com.example.jpa.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TestJPAController {

    @Autowired
    private RegionRepository regionRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/region")
    public ResponseEntity region(){
        return ResponseEntity.ok(regionRepository.findAll());
    }

    @GetMapping("/city")
    public ResponseEntity city(){
        return ResponseEntity.ok(cityRepository.findAll());
    }

    @GetMapping("/cityByRegion")
    public ResponseEntity city(@RequestBody Region region){
        return ResponseEntity.ok(cityRepository.findAllByRegionId(region.getId()));
    }

    @GetMapping("/client")
    public ResponseEntity client(){
        return ResponseEntity.ok(clientRepository.findAll());
    }

    @GetMapping("/clientByCity")
    public ResponseEntity client(@RequestBody City city){
        return ResponseEntity.ok(clientRepository.findAllByCityId(city.getId()));
    }
}
