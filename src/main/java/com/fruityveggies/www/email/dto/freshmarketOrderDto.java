package com.fruityveggies.www.email.dto;

import com.fruityveggies.www.repository.Order;

import lombok.Data;

@Data
public class freshmarketOrderDto {

    private String ordername;
    private String orderphone;
    private String orderaddress1;
    private String orderaddress2;
    private String orderquest;
    private int price;
    private int count;
    
    public Order toEntity() {
        return Order.builder()
                .ordername(ordername)
                .orderphone(orderphone)
                .orderaddress1(orderaddress1)
                .orderaddress2(orderaddress2)
                .orderquest(orderquest)
                .price(price)
                .count(count)
                .build();
    }
}
