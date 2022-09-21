package com.shop.bookstore.repositories;

import com.shop.bookstore.domain.Address;
import com.shop.bookstore.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}