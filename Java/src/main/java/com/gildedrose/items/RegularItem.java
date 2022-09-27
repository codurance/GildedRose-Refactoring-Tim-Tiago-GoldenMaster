package com.gildedrose.items;

import com.gildedrose.Item;

public class RegularItem extends BaseItem {

    public RegularItem(Item item) {
        super(item);
    }

    public void updateQuality() {
        decrementSellIn();
        decrementQuality();
        if (isSellInNegative()) {
            decrementQuality();
        }
    }

}
