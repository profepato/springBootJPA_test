package com.example.jpa.repository;

import com.example.jpa.model.City;
import com.example.jpa.model.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClientRepository extends CrudRepository<Client, Integer> {
    List<Client> findAll();

    List<Client> findAllByCityId(Integer cityId);
}
