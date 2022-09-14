package com.shop.bookstore.resources;

import com.shop.bookstore.domain.City;
import com.shop.bookstore.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/cities")
public class CityResource {

    @Autowired
    private CityService service;

    @RequestMapping(value = "/{stateId}", method = RequestMethod.GET)
    public ResponseEntity<List<City>> findCitiesByState(@PathVariable Long stateId) {
        List<City> cities = service.findCitiesByStateId(stateId);
        return ResponseEntity.ok().body(cities);
    }
}