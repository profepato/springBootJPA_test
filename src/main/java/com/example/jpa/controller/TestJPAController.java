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

import java.util.Optional;

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

    @GetMapping("/testAddCity")
    public ResponseEntity add(){
        Region region = new Region();
        region.setName("Region nueva");

        regionRepository.save(region);

        City city = new City();

        city.setName("Ciudad nueva");
        city.setRegion(region);

        return ResponseEntity.ok(cityRepository.save(city));
    }

    @GetMapping("/testAddCity2")
    public ResponseEntity add2(){
        Optional<Region> regionOptional = regionRepository.findById(3);

        if(regionOptional.isPresent()){
            Region region = regionOptional.get();

            City city = new City();

            city.setName("Ciudad nueva 2");
            city.setRegion(region);

            return ResponseEntity.ok(cityRepository.save(city));
        }

        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/updateRegion")
    public ResponseEntity update(){
        Optional<Region> regionOptional = regionRepository.findById(8);

        if(regionOptional.isPresent()){
            Region region = regionOptional.get();

            region.setName("Cambio de region");

            return ResponseEntity.ok(regionRepository.save(region));
        }

        return ResponseEntity.badRequest().build();
    }
}
