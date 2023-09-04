package com.nhnacademy.mart;

import java.util.ArrayList;

/**
 * .food stand
 */
public class FoodStand {

    private final ArrayList<Food> foods = new ArrayList<>();

    // 임의
    public ArrayList<Food> getFoods() {
        return foods;
    }

    // TODO add 메서드 구현
    void add(Food food) {
        foods.add(food);
    }


    // TODO 장바구니에 담은 Food 삭제 구현
    void delete(Food food) {
        foods.remove(food);
    }
}
