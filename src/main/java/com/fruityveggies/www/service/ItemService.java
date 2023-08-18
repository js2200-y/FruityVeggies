package com.fruityveggies.www.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fruityveggies.www.dto.ItemItemOptionDto;
import com.fruityveggies.www.repository.Cart;
import com.fruityveggies.www.repository.CartRepository;
import com.fruityveggies.www.repository.Item;
import com.fruityveggies.www.repository.ItemRepository;
import com.fruityveggies.www.repository.OrderItems;
import com.fruityveggies.www.repository.OrderItemsRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;
    
    @Autowired
    private OrderItemsRepository orderItemsRepository;
    
    @Autowired
    private CartRepository cartRepository;
    
    public Item findItemById(long id) {
        return itemRepository.findItemById(id);
        
    }
    
    public List<ItemItemOptionDto> getJoinedItemAndItemOptionByItemId(long id){
        return itemRepository.getJoin(id);
    }

    @Transactional
	public void itemOrderSave(List<String> names, List<Integer> counts, List<Integer> prices, Long id,
			String userId) {
		
		int result = orderItemsRepository.deleteByUserEmail(userId);
		
		log.info("result : {}",result);
		
			for(int j=0; j < names.size(); j++) {
				orderItemsRepository.save(OrderItems.builder()
						.name(names.get(j))
						.cnt(Integer.valueOf(counts.get(j)))
						.price(Integer.valueOf(prices.get(j)))
						.itemid(id)
						.useremail(userId)
						.build());

			}

	}
	
    @Transactional
	public void cartSave(List<String> names, List<Integer> counts, List<Integer> prices, Long id,
			String userId) {
		int upCount = 0;
		int saveCount = 0;
		List<Cart> idLists = cartRepository.findByItemId(id);
		
		// 비어 있으면 걍 save
		if(idLists.size() <= 0) {
			for(int j=0; j < names.size(); j++) {
				cartRepository.save(Cart.builder()
						.name(names.get(j))
						.cnt(Integer.valueOf(counts.get(j)))
						.price(Integer.valueOf(prices.get(j)))
						.itemid(id)
						.useremail(userId)
						.build());
				log.info("비어있다");
			}
			
			// 아이템 아이디가 같고 네임이 같으면 cnt 변경
			// 아이템 아이디가 같지않고 네임도 같지 않으면 걍 save
		}else {
			for(int i=0;i<idLists.size();i++) {
				for(int j=0;j<names.size();j++) {
					if (idLists.get(i).getItemid() == id && idLists.get(i).getName().equals(names.get(j))) {
						cartRepository.updateCnt(counts.get(j), names.get(j));
						log.info("updateCount={}",upCount+=1);
					} 
					/*
					 * else if(idLists.get(i).getItemid() == id &&
					 * !idLists.get(i).getName().equals(names.get(j)) ) {
					 * cartRepository.save(Cart.builder() .name(names.get(j))
					 * .cnt(Integer.valueOf(counts.get(j))) .price(Integer.valueOf(prices.get(j)))
					 * .itemid(id) .useremail(userId) .build());
					 * log.info("saveCount={}",saveCount+=1); }
					 */
				}
				
			}
		}
		
	}

	public List<Cart> read(String id) {
		
		return cartRepository.findByUserEmailOrderByDesc(id);
	}
    

}
