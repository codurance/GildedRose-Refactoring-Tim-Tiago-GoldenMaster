package com.gildedrose.items;

import com.gildedrose.Item;

public abstract class BaseItem {

    private final Item item;

    public BaseItem(Item item) {
        this.item = item;
    }

    public abstract void updateQuality();

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

    protected void decrementQualityBy(int value) {
        if (item.quality > 0) {
            item.quality -= value;
        }
    }

    protected void decrementSellIn() {
        item.sellIn--;
    }

    protected void zeroQuality() {
        item.quality = 0;
    }
}
