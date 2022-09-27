package com.gildedrose.items;

import com.gildedrose.Item;

public class AgedBrie extends BaseItem {

    public AgedBrie(Item item) {
        super(item);
    }

    public static boolean is(Item item) {
        return item.name.equals("Aged Brie");
    }

    @Override
    public void updateQuality() {
        decrementSellIn();
        incrementQuality();
        if (isSellInNegative()) {
            incrementQuality();
        }
    }
}
