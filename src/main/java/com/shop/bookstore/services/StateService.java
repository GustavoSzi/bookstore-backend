package com.shop.bookstore.services;

import com.shop.bookstore.domain.State;
import com.shop.bookstore.repositories.StateRepository;
import com.shop.bookstore.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StateService {
    @Autowired
    private StateRepository repo;

    public List<State> findAll() {
        List<State> list = repo.findAll();
        return list;
    }

    public State findById(Long id) {
        Optional<State> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object with id " + id + " not found."));
    }
}