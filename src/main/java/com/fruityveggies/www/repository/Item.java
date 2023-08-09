package com.fruityveggies.www.repository.order;

import java.util.ArrayList;
import java.util.List;

import com.fruityveggies.www.repository.member.Member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor // Parameter로 모든 변수를 받는 생성자
@NoArgsConstructor  // Parameter가 없는 생성자
@Entity // Jpa에서 관리하는 클래스로 테이블과 자동 매핑
@Getter
@Table(name = "ITEM")
@SequenceGenerator(name = "ITEM_SEQ_GEN", sequenceName = "ITEM_SEQ", allocationSize = 1)
public class Item {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ITEM_SEQ_GEN")
    private Long id;
    
    @Column(nullable = false)
    private String itemName; // 상품 이름
    
    @Column(nullable = false)
    private int price; // 상품 가격
    
    @Column(nullable = false)
    private String itemDetail; // 상품 정보
    
    @Column(nullable = false) 
    private String image_path;
    
    /*
     * @Column(nullable = false) private int count; // 상품 개수
     */    
    
    // 판매자 연결
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private Member user;

    
    @OneToMany(mappedBy = "item")
    private List<OrderList> orderLists = new ArrayList<>();
    
    
//    @OneToMany(mappedBy = "item")
//    private List<CartItem> cart_item = new ArrayList<>();
  
    
    
    
}
