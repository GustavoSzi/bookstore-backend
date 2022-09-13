package com.shop.bookstore.resources;

import com.shop.bookstore.domain.State;
import com.shop.bookstore.repositories.StateRepository;
import com.shop.bookstore.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping(value = "/states")
public class StateResource {

    @Autowired
    private StateService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<State>> findAll() {
        List<State> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<State> findById(@PathVariable("id") Long id) {
        State obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}