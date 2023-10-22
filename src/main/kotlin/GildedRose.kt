package dev.wolfremium.www

class GildedRose(var items: List<Item>) {
    fun updateQuality() {
        items.forEach { item ->
            val maxQuality = 50
            val minQuality = 0
            val agedBrie = "Aged Brie"
            val backstagePasses = "Backstage passes to a TAFKAL80ETC concert"
            val qualityIncrease = 1
            val qualityDecrease = 1
            val isNotTheMaximumQuality = item.quality < maxQuality
            val isAgedBrie = item.name == agedBrie
            val isABackStagePass = item.name == backstagePasses
            val areAgeBrieOrPasses = isAgedBrie || isABackStagePass
            val hasQuality = item.quality > minQuality
            if (areAgeBrieOrPasses) {
                if (isNotTheMaximumQuality) {
                    item.quality += qualityIncrease
                    if (isABackStagePass) {
                        val backstagePassesBigThreshold = 11
                        val areInDateToBeSold = item.sellIn < backstagePassesBigThreshold
                        if (areInDateToBeSold && isNotTheMaximumQuality) {
                            item.quality = item.quality + qualityIncrease
                        }

                        val backstagePassesSmallThreshold = 6
                        val areOnTheLastDays = item.sellIn < backstagePassesSmallThreshold
                        if (areOnTheLastDays && isNotTheMaximumQuality) {
                            item.quality = item.quality + qualityIncrease
                        }
                    }
                }
            } else {
                if (hasQuality && isNotSulfuras(item)) {
                    item.quality = item.quality - qualityDecrease
                }
            }

            decreaseSellIn(item)

            val notExpiredNumber = 0
            val isExpired = item.sellIn < notExpiredNumber
            if (isExpired) {
                if (isAgedBrie) {
                    if (isNotTheMaximumQuality) {
                        item.quality = item.quality + qualityIncrease
                    }
                } else {
                    if (isABackStagePass) {
                        item.quality = item.quality - item.quality
                    } else {
                        if (hasQuality && isNotSulfuras(item)) {
                            item.quality = item.quality - qualityDecrease
                        }
                    }
                }
            }
        }
    }

    private fun isNotSulfuras(item: Item): Boolean {
        val sulfuras = "Sulfuras, Hand of Ragnaros"
        return item.name != sulfuras
    }

    private fun decreaseSellIn(item: Item) {
        if (isNotSulfuras(item)) {
            val dayDecrease = 1
            item.sellIn -= dayDecrease
        }
    }


}
