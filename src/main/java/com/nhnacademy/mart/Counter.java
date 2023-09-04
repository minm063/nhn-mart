package com.nhnacademy.mart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * .counter
 */
public class Counter {
//    private static final Logger logger = LoggerFactory.getLogger(Counter.class);
    // TODO pay 메서드 구현 (카운터에서 계산 처리 메서드)

    private int price;

    public int getPrice() {
        return price;
    }

    /**
     * .sum price
     *
     * @param basket basket
     *
     * @return price
     */
    public int pay(Basket basket) {
        // 금액 산정
        // name으로 count(amount) * 각 price
        for (Food eachFood : basket.getFoods()) {
            price += eachFood.getPrice();
        }
//        logger.info("in counter : price is {}", price);
        return price;
    }
}
