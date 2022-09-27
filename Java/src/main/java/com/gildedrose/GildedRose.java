package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (isAgedBrie(item)) {
                updateAgedBrie(item);
            } else if (isBackstage(item)) {
                updateBackstage(item);
            } else if (!isSulfuras(item)) {
                updateRegular(item);
            }
        }
    }

    private void updateRegular(Item item) {
        decrementSellIn(item);
        decrementQuality(item);
        if (item.sellIn < 0) {
            decrementQuality(item);
        }
    }

    private void updateBackstage(Item item) {
        decrementSellIn(item);
        incrementQuality(item);

        if (item.sellIn < 10 ) {
            incrementQuality(item);
        }
        if (item.sellIn < 5) {
            incrementQuality(item);
        }
        if (item.sellIn < 0) {
            zeroQuality(item);
        }
    }

    private void updateAgedBrie(Item item) {
        decrementSellIn(item);
        incrementQuality(item);
        if (item.sellIn < 0) {
            incrementQuality(item);
        }
    }

    private boolean isSulfuras(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean isBackstage(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isAgedBrie(Item item) {
        return item.name.equals("Aged Brie");
    }

    private void incrementQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }

    private void decrementQuality(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
    }

    private void decrementSellIn(Item item) {
        item.sellIn--;
    }

    private void zeroQuality(Item item) {
        item.quality = 0;
    }
}
