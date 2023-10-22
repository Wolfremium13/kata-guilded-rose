package dev.wolfremium.www

class GildedRose(var items: List<Item>) {
    fun updateQuality() {
        items.forEach { item ->
            increaseQuality(item)
            decreaseQuality(item)
        }
    }

    private fun decreaseQuality(item: Item) {
        val minQuality = 0
        val hasQuality = item.quality > minQuality
        if(!hasQuality) return
        val isAgedBrie = isAgedBrie(item)
        val isABackStagePass = isABackstagePass(item)
        val isExpired = isExpired(item)
        val qualityDecrease = 1
        val areAgeBrieOrPasses = isAgedBrie || isABackStagePass
        if (!areAgeBrieOrPasses && isNotSulfuras(item)) {
            item.quality -= qualityDecrease
        }
        if (isExpired) {
            if (!isAgedBrie) {
                if (isABackStagePass) {
                    item.quality = minQuality
                } else {
                    if (isNotSulfuras(item)) {
                        item.quality -= qualityDecrease
                    }
                }
            }
        }
    }

    private fun increaseQuality(item: Item) {
        val maxQuality = 50
        val isNotTheMaximumQuality = item.quality < maxQuality
        val isAgedBrie = isAgedBrie(item)
        val isABackStagePass = isABackstagePass(item)
        val qualityIncrease = 1
        val areAgeBrieOrPasses = isAgedBrie || isABackStagePass
        if (areAgeBrieOrPasses) {
            if (isNotTheMaximumQuality) {
                item.quality += qualityIncrease
                if (isABackStagePass) {
                    val backstagePassesBigThreshold = 11
                    val areInDateToBeSold = item.sellIn < backstagePassesBigThreshold
                    if (areInDateToBeSold && isNotTheMaximumQuality) {
                        item.quality += qualityIncrease
                    }

                    val backstagePassesSmallThreshold = 6
                    val areOnTheLastDays = item.sellIn < backstagePassesSmallThreshold
                    if (areOnTheLastDays && isNotTheMaximumQuality) {
                        item.quality += qualityIncrease
                    }
                }
            }
        }
        decreaseSellIn(item)
        val isExpired = isExpired(item)
        if (isExpired && isAgedBrie && isNotTheMaximumQuality) {
            item.quality += qualityIncrease
        }
    }

    private fun decreaseSellIn(item: Item) {
        if (isNotSulfuras(item)) {
            val dayDecrease = 1
            item.sellIn -= dayDecrease
        }
    }

    private fun isNotSulfuras(item: Item): Boolean {
        val sulfuras = "Sulfuras, Hand of Ragnaros"
        return item.name != sulfuras
    }
    private fun isAgedBrie(item: Item): Boolean {
        val agedBrie = "Aged Brie"
        return item.name == agedBrie
    }
    private fun isABackstagePass(item: Item): Boolean {
        val backstagePass = "Backstage passes to a TAFKAL80ETC concert"
        return item.name == backstagePass
    }
    private fun isExpired(item: Item): Boolean {
        val expiredLimit = 0
        return item.sellIn < expiredLimit
    }

}
