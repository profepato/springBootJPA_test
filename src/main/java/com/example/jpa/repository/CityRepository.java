package com.example.jpa.repository;

import com.example.jpa.model.City;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CityRepository extends CrudRepository<City, Integer> {
    List<City> findAll();

    List<City> findAllByRegionId(Integer regionId);
}
