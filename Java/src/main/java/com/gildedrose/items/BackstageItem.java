package com.gildedrose.items;

import com.gildedrose.Item;

public class BackstageItem extends BaseItem {
    public BackstageItem(Item item) {
        super(item);
    }

    public static boolean is(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    @Override
    public void updateQuality() {
        decrementSellIn();
        if (isSellInNegative()) {
            zeroQuality();
        } else {
            incrementQuality();
            if (isSellInBelow(10)) {
                incrementQuality();
            }
            if (isSellInBelow(5)) {
                incrementQuality();
            }
        }
    }
}
