package dev.wolfremium.www

class GildedRose(var items: List<Item>) {
    fun updateQuality() {
        for (i in items.indices) {
            val maxQuality = 50
            val minQuality = 0
            val agedBrie = "Aged Brie"
            val backstagePasses = "Backstage passes to a TAFKAL80ETC concert"
            val sulfuras = "Sulfuras, Hand of Ragnaros"
            val qualityIncrease = 1
            val qualityDecrease = 1
            if (items[i].name != agedBrie && items[i].name != backstagePasses) {
                if (items[i].quality > minQuality) {
                    if (items[i].name != sulfuras) {
                        items[i].quality = items[i].quality - qualityDecrease
                    }
                }
            } else {
                if (items[i].quality < maxQuality) {
                    items[i].quality = items[i].quality + qualityIncrease

                    if (items[i].name == backstagePasses) {
                        val backstagePassesBigThreshold = 11
                        if (items[i].sellIn < backstagePassesBigThreshold) {
                            if (items[i].quality < maxQuality) {
                                items[i].quality = items[i].quality + qualityIncrease
                            }
                        }

                        val backstagePassesSmallThreshold = 6
                        if (items[i].sellIn < backstagePassesSmallThreshold) {
                            if (items[i].quality < maxQuality) {
                                items[i].quality = items[i].quality + qualityIncrease
                            }
                        }
                    }
                }
            }

            if (items[i].name != sulfuras) {
                items[i].sellIn = items[i].sellIn - 1
            }

            if (items[i].sellIn < minQuality) {
                if (items[i].name != agedBrie) {
                    if (items[i].name != backstagePasses) {
                        if (items[i].quality > minQuality) {
                            if (items[i].name != sulfuras) {
                                items[i].quality = items[i].quality - qualityDecrease
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality
                    }
                } else {
                    if (items[i].quality < maxQuality) {
                        items[i].quality = items[i].quality + qualityIncrease
                    }
                }
            }
        }
    }
}
