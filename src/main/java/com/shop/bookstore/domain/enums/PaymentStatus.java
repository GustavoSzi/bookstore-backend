package com.shop.bookstore.domain.enums;

public enum PaymentStatus {
    
    PENDING(1, "Pending payment"),
    PAID(2, "Paid"),
    CANCELED(3, "Canceled");

    private Integer cod;
    private String description;

    private PaymentStatus(Integer cod, String description) {
        this.cod = cod;
        this.description = description;
    }

    public Integer getCod() {
        return cod;
    }

    public String getDescription() {
        return description;
    }

    public static PaymentStatus toEnum(Integer cod) {
        if(cod == null) {
            return null;
        }

        for(PaymentStatus e : PaymentStatus.values()) {
            if(cod.equals(e.getCod())){
                return e;
            }
        }

        throw new IllegalArgumentException("Id not found: " + cod);
    }
}