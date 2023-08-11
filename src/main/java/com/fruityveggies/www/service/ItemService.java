package com.fruityveggies.www.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fruityveggies.www.repository.Item;
import com.fruityveggies.www.repository.ItemOption;
import com.fruityveggies.www.repository.ItemRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    
    @Transactional(readOnly = true)
    public List<Item> getItemsWithItemOption(Long itemId) {
        log.info("getItemsWithItemOption(itemOption={})", itemId);

        return itemRepository.findItemsWithItemOption(itemId);
    }
}
