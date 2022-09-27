package com.gildedrose;

import com.gildedrose.items.BaseItem;
import com.gildedrose.items.ItemFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class GildedRose {

    Item[] items;
    private final List<BaseItem> itemsClassified;

    public GildedRose(Item[] items) {
        this.items = items;
        this.itemsClassified = classifyItems(items);
    }

    private static List<BaseItem> classifyItems(Item[] items) {
        return Arrays.stream(items).map(ItemFactory::createItem)
            .collect(Collectors.toList());
    }

    public void updateQuality() {
        itemsClassified.forEach(BaseItem::updateQuality);
    }

}
