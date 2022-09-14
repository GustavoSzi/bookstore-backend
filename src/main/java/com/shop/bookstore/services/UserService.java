package com.shop.bookstore.services;

import com.shop.bookstore.domain.User;
import com.shop.bookstore.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        List<User> list = repo.findAll();
        return list;
    }
}