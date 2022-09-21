package com.shop.bookstore.domain;

import com.shop.bookstore.domain.enums.PaymentStatus;

import javax.persistence.Entity;

@Entity
public class PaymentWithCreditCard extends Payment{
    private static final long serialVersionUID = 1L;

    private Integer numOfParcels;

    public PaymentWithCreditCard() {}

    public PaymentWithCreditCard(Long id, PaymentStatus paymentStatus, Order order, Integer numOfParcels) {
        super(id, paymentStatus, order);
        this.numOfParcels = numOfParcels;
    }

    public Integer getNumOfParcels() {
        return numOfParcels;
    }

    public void setNumOfParcels(Integer numOfParcels) {
        this.numOfParcels = numOfParcels;
    }
}