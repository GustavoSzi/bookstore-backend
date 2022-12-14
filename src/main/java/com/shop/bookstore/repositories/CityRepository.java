package com.shop.bookstore.repositories;

import com.shop.bookstore.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    public List<City> findCitiesByStateId(Long stateId);
}