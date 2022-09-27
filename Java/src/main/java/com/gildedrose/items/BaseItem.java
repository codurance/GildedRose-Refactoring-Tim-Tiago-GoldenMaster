package com.gildedrose.items;

import com.gildedrose.Item;

public class BaseItem {

    private final Item item;

    public BaseItem(Item item) {
        this.item = item;
    }

    public void updateQuality() {}

    protected boolean isSellInBelow(int value) {
        return item.sellIn < value;
    }
    protected boolean isSellInNegative() {
        return isSellInBelow(0);
    }

    protected void incrementQuality() {
        if (item.quality < 50) {
            item.quality++;
        }
    }

    protected void decrementQuality() {
        if (item.quality > 0) {
            item.quality--;
        }
    }

    protected void decrementSellIn() {
        item.sellIn--;
    }

    protected void zeroQuality() {
        item.quality = 0;
    }
}
