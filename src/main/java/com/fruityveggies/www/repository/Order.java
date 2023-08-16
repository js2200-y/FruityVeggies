package com.fruityveggies.www.repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@Entity
@Table(name = "ORDERS")
@SequenceGenerator(name = "ORDERS_SEQ_GEN", sequenceName = "ORDERS_SEQ", allocationSize = 1)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDERS_SEQ_GEN")
    private Long id;
    
    private int price;
    
    private int count;
    
    private Long orderitem_id;
    
    @Column(nullable = false)
    private String ordername;
    
    @Column(nullable = false)
    private String orderphone;

    @Column(nullable = false)
    private String orderaddress1;
    
    @Column(nullable = false)
    private String orderaddress2;
    
    @Column(nullable = false)
    private String orderrequest;
    
    
}
