package com.nhnacademy.mart;

import java.util.ArrayList;

/**
 * .Basket
 */
public class Basket {
    private final ArrayList<Food> foods = new ArrayList<>();

    // 임의
    public ArrayList<Food> getFoods() {
        return foods;
    }

    public void add(Food food) {
        foods.add(food);
    }
}
