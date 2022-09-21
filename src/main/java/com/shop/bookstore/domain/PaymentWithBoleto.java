package com.shop.bookstore.domain;

import com.shop.bookstore.domain.enums.PaymentStatus;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class PaymentWithBoleto extends Payment{
    private static final long serialVersionUID = 1L;

    private Date paymentDate;
    private Date expirationDate;

    public PaymentWithBoleto() {}

    public PaymentWithBoleto(Long id, PaymentStatus paymentStatus, Order order,Date paymentDate, Date expirationDate) {
        super(id, paymentStatus, order);
        this.paymentDate = paymentDate;
        this.expirationDate = expirationDate;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
}