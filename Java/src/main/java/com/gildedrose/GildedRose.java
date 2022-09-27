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
        if (item.quality > 0) {
            decrementQuality(item);
        }
        item.sellIn--;
        if (item.sellIn < 0) {
            if (item.quality > 0) {
                decrementQuality(item);
            }
        }
    }

    private void updateBackstage(Item item) {
        if (item.quality < 50) {
            incrementQuality(item);

            if (item.sellIn < 11) {
                if (item.quality < 50) {
                    incrementQuality(item);
                }
            }
            if (item.sellIn < 6) {
                if (item.quality < 50) {
                    incrementQuality(item);
                }
            }
        }
        item.sellIn--;
        if (item.sellIn < 0) {
            zeroQuality(item);
        }
    }

    private void updateAgedBrie(Item item) {
        if (item.quality < 50) {
            incrementQuality(item);
        }
        item.sellIn--;
        if (item.sellIn < 0) {
            if (item.quality < 50) {
                incrementQuality(item);
            }
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

    private boolean isRegularItem(Item item) {
        return !isAgedBrie(item) && !isBackstage(item) && !isSulfuras(item);
    }

    private void incrementQuality(Item item) {
        item.quality++;
    }

    private void decrementQuality(Item item) {
        item.quality--;
    }

    private void zeroQuality(Item item) {
        item.quality = 0;
    }
}
