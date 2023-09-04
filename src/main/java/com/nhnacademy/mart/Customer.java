package com.nhnacademy.mart;

import java.util.ArrayList;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

/**
 * .Customer
 */
public class Customer {
//    private final Logger logger = LoggerFactory.getLogger(Customer.class);
    // 고객 구매 목록
    private final BuyList buyList;

    // 고객 장바구니
    private Basket basket;

    public Customer(BuyList buyList) {
        this.buyList = buyList;
    }

    // 장바구니 챙기기
    public void bring(Basket basket) {
        this.basket = basket;
    }

    // TODO pickFoods 메서드 구현

    /**
     * .food stand
     *
     * @param foodStand food stand
     *
     */
    public void pickFoods(FoodStand foodStand) {
        ArrayList<Food> food = foodStand.getFoods();
        boolean isFalse = true;
        for (BuyList.Item item : buyList.getItems()) {
            // foodStand에 buyList 항목이 있으면 삭제 후 장바구니에 담음
            for (int i = 0; i < food.size(); i++) {
                if (food.get(i).getName().equals(item.getName())) {
//                    logger.info("has : {}", food.get(i).getName());
                    for (int j = 0; j < item.getAmount(); j++) {
                        if (food.get(i).getName().equals(item.getName())) {
                            basket.add(food.get(i));
                            foodStand.delete(food.get(i));
                        } else {
                            throw new IllegalArgumentException("재고가 부족합니다");
                        }
                    }
                    isFalse = false;
                    break;
                }
            }
            if (isFalse) {
                throw new IllegalArgumentException("식품 매대에 없는 상품입니다.");
            }
        }
    }

    // TODO payTox 메서드 구현
    /**
     * .price
     *
     * @param counter calculate price
     */
    public void payTox(Counter counter) {
        int price = counter.pay(basket);
        System.out.println("총 가격은 " + price + "원 입니다.");
        if (20_000 - price < 0) {
            throw new IllegalArgumentException("돈을 초과하는 상품 구매입니다.");
        }
        System.out.println("고객님 결제 후 잔액 : " + (20000 - price));
    }

}
