package com.shop.bookstore.domain;

import com.shop.bookstore.domain.enums.PaymentStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Payment implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    private Integer paymentStatus;

    @OneToOne
    @JoinColumn(name = "order_id")
    @MapsId
    private Order order;

    public Payment () {}

    public Payment(Long id, PaymentStatus paymentStatus, Order order) {
        this.id = id;
        this.paymentStatus = paymentStatus.getCod();
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PaymentStatus getPaymentStatus() {
        return PaymentStatus.toEnum(paymentStatus);
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus.getCod();
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return id.equals(payment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}