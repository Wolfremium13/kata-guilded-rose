package dev.wolfremium.www

class GildedRose(var items: List<Item>) {
    fun updateQuality() {
        for (item in items) {
          updateQuality(item)
        }
    }

    private fun updateQuality(item: Item) {
        if (item.name != "Aged Brie" && item.name != "Backstage passes to a TAFKAL80ETC concert") {
            if (item.quality > 0) {
                if (item.name != "Sulfuras, Hand of Ragnaros") {
                    item.quality = item.quality - 1
                }
            }
        } else {
            if (item.quality < 50) {
                item.quality = item.quality + 1

                if (item.name == "Backstage passes to a TAFKAL80ETC concert") {
                    if (item.sellIn < 11) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1
                        }
                    }

                    if (item.sellIn < 6) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1
                        }
                    }
                }
            }
        }

        if (item.name != "Sulfuras, Hand of Ragnaros") {
            item.sellIn = item.sellIn - 1
        }

        if (item.sellIn < 0) {
            if (item.name != "Aged Brie") {
                if (item.name == "Backstage passes to a TAFKAL80ETC concert") {
                    item.quality = item.quality - item.quality
                    return
                }

                if (item.quality > 0) {
                    if (item.name == "Sulfuras, Hand of Ragnaros") {
                        return
                    }
                    item.quality = item.quality - 1
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1
                }
            }
        }
    }
}
