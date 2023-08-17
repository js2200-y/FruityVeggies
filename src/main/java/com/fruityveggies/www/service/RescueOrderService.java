package com.fruityveggies.www.service;

import org.springframework.stereotype.Service;

import com.fruityveggies.www.dto.RescueOrderDto;
import com.fruityveggies.www.repository.rescue.RescueOrder;
import com.fruityveggies.www.repository.rescue.RescueOrderRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class RescueOrderService {

    private final RescueOrderRepository rescueOrderRepository;
    
    public RescueOrder create (RescueOrderDto dto) {
        
        log.info("create(dto={})", dto);
        
        RescueOrder entity = dto.toEntity();
        log.info("entity={}", entity );
        
        rescueOrderRepository.save(entity);
        log.info("entity={}", entity);
        
        return entity;
        
    }
}