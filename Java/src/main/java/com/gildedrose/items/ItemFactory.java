package com.gildedrose.items;

import com.gildedrose.Item;

public class ItemFactory {

    public static BaseItem createItem(Item item) {
        if (AgedBrie.is(item)) {
            return new AgedBrie(item);
        }
        if (BackstageItem.is(item)) {
            return new BackstageItem(item);
        }
        if (SulfurasItem.is(item)) {
            return new SulfurasItem(item);
        }
        if (ConjuredItem.is(item)) {
            return new ConjuredItem(item);
        }
        return new RegularItem(item);
    }
}
