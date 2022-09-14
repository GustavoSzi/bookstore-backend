package com.shop.bookstore.services;

import com.shop.bookstore.domain.City;
import com.shop.bookstore.repositories.CityRepository;
import com.shop.bookstore.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository repo;

    public List<City> findCitiesByStateId(Long stateId) {
        List<City> cities = repo.findCitiesByStateId(stateId);
        if(cities.isEmpty()) {
            throw new ObjectNotFoundException("Não encontrado");
        }
        return cities;
    }
}