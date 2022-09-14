package com.shop.bookstore.services;

import com.shop.bookstore.domain.Address;
import com.shop.bookstore.domain.City;
import com.shop.bookstore.domain.State;
import com.shop.bookstore.domain.User;
import com.shop.bookstore.repositories.AddressRepository;
import com.shop.bookstore.repositories.CityRepository;
import com.shop.bookstore.repositories.StateRepository;
import com.shop.bookstore.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private StateRepository stateRepository;
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressRepository addressRepository;

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

        User u1 = new User(null, "Roberto", "Oliveira", "roberto@email.com");
        User u2 = new User(null, "Alexa", "Amazon", "alexa@email.com");
        User u3 = new User(null, "Gertrudes", "Silva", "gertr@email.com");

        u1.getPhones().addAll(Arrays.asList("123456789", "14456744"));
        u2.getPhones().addAll(Arrays.asList("143424243"));
        u3.getPhones().addAll(Arrays.asList("756865543", "57352424"));

        Address ad1 = new Address(null, "Rua do exemplo", "Limoeiro", "134A", null, "09876000", st1, c2, u1);
        Address ad2 = new Address(null, "Rua do canário", "Pássaros", "98", "Apto. 92", "09312945", st1, c2, u1);
        Address ad3 = new Address(null, "Avenida Paulista", "Centro", "804", "Conj 25", "87654020", st1, c2, u2);
        Address ad4 = new Address(null, "Paz de Espirito Santo", "Formosura", "222", null, "65436872", st4, c10, u3);
        Address ad5 = new Address(null, "Rua de Janeiro", "Donzelas", "181B", null, "85463098", st2, c6, u3);

        u1.getAddresses().addAll(Arrays.asList(ad1, ad2));
        u2.getAddresses().add(ad3);
        u3.getAddresses().addAll(Arrays.asList(ad4, ad5));

        userRepository.saveAll(Arrays.asList(u1, u2, u3));
        addressRepository.saveAll(Arrays.asList(ad1, ad2, ad3, ad4, ad5));

    }
}