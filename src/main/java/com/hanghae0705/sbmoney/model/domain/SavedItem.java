package com.hanghae0705.sbmoney.model.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.hanghae0705.sbmoney.model.domain.baseEntity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@RequiredArgsConstructor
public class SavedItem extends BaseEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    @JsonBackReference(value = "user-fk")
    User user;

    @Column(nullable = false)
    int price;

    @OneToOne
    @JoinColumn(name = "ITEM_ID")
    @JsonBackReference(value = "item-fk")
    Item item;

    @ManyToOne
    @JoinColumn(name = "GOAL_ITEM_ID")
    @JsonBackReference(value = "goalItem-fk")
    GoalItem goalItem;

    public SavedItem(Item item, int price, User user){
        this.item = item;
        this.price = price;
        this.user = user;
    }
    
    //User 객체를 받을 때 추후 삭제
    public SavedItem(Item item, int price){
        this.item = item;
        this.price = price;
    }

    public void update(int price){
        this.price = price;
    }


    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Request {
        private Long itemId;
        private int price;
    }
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Update {
        private int price;
    }

    @Getter
    @AllArgsConstructor
    public static class Response {
        private Long categoryId;
        private String categoryName;
        private Long itemId;
        private String itemName;
        private int price;
    }

}