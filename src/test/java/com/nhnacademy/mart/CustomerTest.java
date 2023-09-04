package com.nhnacademy.mart;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CustomerTest {

    @Test
    @DisplayName("잘못된 입력")
    void buyListTest() {
        String str = "abcde ab";
        BuyList buyList = new BuyList();
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> buyList.add(str));
    }

    @Test
    @DisplayName("재고가 부족합니다")
    void pickFoods() {
        BuyList buyList = new BuyList();
        buyList.add("양파 3");
        Customer customer = new Customer(buyList);
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> customer.pickFoods(new FoodStand()));
    }

    @Test
    @DisplayName("식품 매대에 없는 상품입니다")
    void pickFoodsTest() {
        BuyList buyList = new BuyList();
        buyList.add("고기 3");
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Customer(buyList).pickFoods(new FoodStand()));
    }

//    @Test
//    void payTox(Counter counter) {
//        Basket basket = new Basket();
//        basket.add(new Food("고기", 3000));
//        basket.add(new Food("생선", 10000));
//        counter.pay(basket);
//        payTox(counter);
//    }
//
//    @Test
//    @DisplayName("총액 초과")
//    void priceTest(Counter counter) {
//        Basket basket = new Basket();
//        basket.add(new Food("사과", 2000));
//        basket.add(new Food("고기", 4000));
//
//
//        counter.pay(basket);
//        // new Customer(buyList).payTox(new Customer(buyList))
//        //new Customer(buyList).pickFoods(new FoodStand());
//        Assertions.assertThrows(IllegalArgumentException.class,
//                () -> payTox(new Counter()));
//    }

}