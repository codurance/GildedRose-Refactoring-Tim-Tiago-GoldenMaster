package com.gildedrose.items;

import com.gildedrose.Item;

public class RegularItem extends BaseItem {

    private final int velocity;

    public RegularItem(Item item) {
        this(item, 1);
    }

    protected RegularItem(Item item, int velocity) {
        super(item);
        this.velocity = velocity;
    }

    public void updateQuality() {
        decrementSellIn();
        decrementQualityBy(velocity);
        if (isSellInNegative()) {
            decrementQualityBy(velocity);
        }
    }

}
