package com.shop.bookstore.repositories;

import com.shop.bookstore.domain.Address;
import com.shop.bookstore.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}