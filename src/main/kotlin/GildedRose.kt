package dev.wolfremium.www

class GildedRose(var items: List<Item>) {
    fun updateQuality() {
        items.forEach { item ->
            val maxQuality = 50
            val minQuality = 0
            val agedBrie = "Aged Brie"
            val backstagePasses = "Backstage passes to a TAFKAL80ETC concert"
            val sulfuras = "Sulfuras, Hand of Ragnaros"
            val qualityIncrease = 1
            val qualityDecrease = 1
            if (item.name == agedBrie || item.name == backstagePasses) {
                if (item.quality < maxQuality) {
                    item.quality = item.quality + qualityIncrease
                    if (item.name == backstagePasses) {
                        val backstagePassesBigThreshold = 11
                        if (item.sellIn < backstagePassesBigThreshold && item.quality < maxQuality) {
                            item.quality = item.quality + qualityIncrease
                        }

                        val backstagePassesSmallThreshold = 6
                        if (item.sellIn < backstagePassesSmallThreshold && item.quality < maxQuality) {
                            item.quality = item.quality + qualityIncrease
                        }
                    }
                }
            } else {
                if (item.quality > minQuality && item.name != sulfuras) {
                    item.quality = item.quality - qualityDecrease
                }
            }

            if (item.name != sulfuras) {
                item.sellIn = item.sellIn - 1
            }

            if (item.sellIn < minQuality) {
                if (item.name == agedBrie) {
                    if (item.quality < maxQuality) {
                        item.quality = item.quality + qualityIncrease
                    }
                } else {
                    if (item.name == backstagePasses) {
                        item.quality = item.quality - item.quality
                    } else {
                        if (item.quality > minQuality && item.name != sulfuras) {
                            item.quality = item.quality - qualityDecrease
                        }
                    }
                }
            }
        }
    }
}
