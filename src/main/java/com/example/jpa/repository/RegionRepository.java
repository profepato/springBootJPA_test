package com.example.jpa.repository;

import com.example.jpa.model.Region;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RegionRepository extends CrudRepository<Region, Integer> {
    List<Region> findAll();
}
