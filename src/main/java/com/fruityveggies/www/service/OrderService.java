package com.fruityveggies.www.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fruityveggies.www.email.dto.freshmarketOrderDto;
import com.fruityveggies.www.repository.Order;
import com.fruityveggies.www.repository.OrderRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;
//    private final OrderItemRepository orderItemRepository;
    

    
    @Transactional(readOnly = true)
    public Order readOrder(Long id) {
        log.info("readOrder(id={})", id);
        
        return orderRepository.findById(id).orElseThrow();
    }
    
    
    public Order create(freshmarketOrderDto dto) {
        log.info("orderCreate(dto={})", dto);
        
        Order entity = dto.toEntity();
        log.info("orderEntity={}", entity);
        
        orderRepository.save(entity);
        log.info("orderEntity={}", entity);
        
        return entity;
    }
    
//    public OrderItem orderRead(Long id) {
//        log.info("orderRead(id={})", id);
//        
//        return orderItemRepository.
//    }
    
}
