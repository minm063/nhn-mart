package com.nhnacademy.mart;

import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * .BuyList
 */
public class BuyList {

    private final ArrayList<Item> items = new ArrayList<>();

    public ArrayList<Item> getItems() {
        return items;
    }

    // TODO add 메서드 생성

    /**
     * .add item
     *
     * @param item item
     *
     */
    public void add(String item) {
        String[] itemSplit = item.split(" ");
        if (itemSplit.length < 2) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        for (int i = 0; i < itemSplit.length / 2; i++) {
            if (Pattern.matches(itemSplit[i*2+1], "[1-9]+")) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
            items.add(new Item(itemSplit[i * 2], Integer.parseInt(itemSplit[i * 2 + 1])));
        }
    }

    /**
     * .item
     */
    public static class Item {
        private final String name;
        private final int amount;

        public Item(String name, int amount) {
            this.name = name;
            this.amount = amount;
        }

        public String getName() {
            return name;
        }

        public int getAmount() {
            return amount;
        }
    }
}
