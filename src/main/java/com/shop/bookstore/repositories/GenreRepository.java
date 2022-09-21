package com.shop.bookstore.repositories;

import com.shop.bookstore.domain.Book;
import com.shop.bookstore.domain.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {
}