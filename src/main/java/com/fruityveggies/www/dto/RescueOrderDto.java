package com.fruityveggies.www.dto;


import java.util.List;

import com.fruityveggies.www.repository.rescue.RescueOrder;

import lombok.Data;

@Data
public class RescueOrderDto {
    
    
    private String boxsize;
    private String weeksize;
    private long boxprice;
    private List<String> dislikeList;
    private String recipient;
    private String phone;
    private String address;
    private String addressdetail;
    private String userId;
    
    public RescueOrder toEntity() {
        return RescueOrder.builder()
                    .BOXSIZE(boxsize)
                    .WEEKSIZE(weeksize)
                    .BOX_PRICE(boxprice)
                    .RECIPIENT(recipient)
                    .PHONE(phone)
                    .ADDRESS(address)
                    .ADDRESS_DETAIL(addressdetail)
                    .build();
    }
    

}