package com.shop.bookstore.repositories;

import com.shop.bookstore.domain.Order;
import com.shop.bookstore.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}