package com.shop.bookstore.services;

import com.shop.bookstore.domain.City;
import com.shop.bookstore.domain.State;
import com.shop.bookstore.repositories.CityRepository;
import com.shop.bookstore.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private StateRepository stateRepository;
    @Autowired
    private CityRepository cityRepository;

    public void instantiateTestDatabase() {
        State st1 = new State(null, "São Paulo");
        State st2 = new State(null, "Rio de Janeiro");
        State st3 = new State(null, "Acre");
        State st4 = new State(null, "Espirito Santo");

        City c1 = new City(null, "São Paulo", st1);
        City c2 = new City(null, "Guarulhos", st1);
        City c3 = new City(null, "Campinas", st1);
        City c4 = new City(null, "Rio de Janeiro", st2);
        City c5 = new City(null, "São Gonçalo", st2);
        City c6 = new City(null, "Duque de Caixas", st2);
        City c7 = new City(null, "Acrelândia", st3);
        City c8 = new City(null, "Assis Brasil", st3);
        City c9 = new City(null, "Serra", st4);
        City c10 = new City(null, "Vila Velha", st4);
        City c11 = new City(null, "Cariacica", st4);

        st1.getCities().addAll(Arrays.asList(c1, c2, c3));
        st2.getCities().addAll(Arrays.asList(c4, c5, c6));
        st3.getCities().addAll(Arrays.asList(c7, c8));
        st4.getCities().addAll(Arrays.asList(c9, c10, c11));

        stateRepository.saveAll(Arrays.asList(st1, st2, st3, st4));
        cityRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11));

    }
}