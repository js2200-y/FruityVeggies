package com.fruityveggies.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fruityveggies.www.dto.ItemItemOptionDto;
import com.fruityveggies.www.repository.Item;
import com.fruityveggies.www.repository.ItemRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;
    
    public Item findItemById(long id) {
        return itemRepository.findItemById(id);
        
    }
    
    public List<ItemItemOptionDto> getJoinedItemAndItemOptionByItemId(long id){
        return itemRepository.getJoin(id);
    }
    

}
