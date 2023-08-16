package com.fruityveggies.www.repository.rescue;

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

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
@Entity // JPA 엔터티 클래스 - 데이터베이스 테이블과 매핑되는 클래스
@Table(name = "REGULARDELIVERY") 
@SequenceGenerator(name = "REGULARDELIVERY_SEQ_GEN", sequenceName = "REGULARDELIVERY_SEQ", allocationSize = 1)
public class RescueOrder {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REGULARDELIVERY_SEQ_GEN")
    private Long ID;
    
    @Column(nullable = false)
    private String BOXSIZE;
    
    @Column(nullable = false)
    private String WEEKSIZE;
    
    @Column(nullable = false)
    private Long BOX_PRICE;
    
    @Column(nullable = false)
    private Long DISLIKEID_1;
    
    private Long DISLIKEID_2;
    private Long DISLIKEID_3;
    
    @Column(nullable = false)
    private String RECIPIENT;
    
    @Column(nullable = false)
    private String PHONE;
    
    @Column(nullable = false)
    private String ADDRESS;
    
    @Column(nullable = false)
    private String ADDRESS_DETAIL;
    
    @Column(nullable = false)
    private String USERID;
    
    
    

}