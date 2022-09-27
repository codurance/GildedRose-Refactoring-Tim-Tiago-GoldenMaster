package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (isAgedBrie(items[i]) || isBackstage(items[i])) {
                if (items[i].quality < 50) {
                    incrementQuality(items[i]);

                    if (isBackstage(items[i])) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                incrementQuality(items[i]);
                            }
                        }
                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                incrementQuality(items[i]);
                            }
                        }
                    }
                }
            } else if (!isSulfuras(items[i])){
                if (items[i].quality > 0) {
                    decrementQuality(items[i]);
                }
            }

            if (!isSulfuras(items[i])) {
                items[i].sellIn--;
            }

            if (items[i].sellIn < 0) {
                if (isAgedBrie(items[i])) {
                    if (items[i].quality < 50) {
                        incrementQuality(items[i]);
                    }
                } else {
                    if (isBackstage(items[i])) {
                        zeroQuality(items[i]);
                    } else {
                        if (!isSulfuras(items[i])) {
                            if (items[i].quality > 0) {
                                decrementQuality(items[i]);}
                        }
                    }
                }
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
