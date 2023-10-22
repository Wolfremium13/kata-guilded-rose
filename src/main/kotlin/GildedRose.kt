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
        if (!hasQuality) return
        val isExpired = isExpired(item)
        val qualityDecrease = 1
        if (isExpired && isABackstagePass(item)) {
            item.quality = minQuality
            return
        }
        val hasAnExpirationDate = !(isAgedBrie(item) || isABackstagePass(item)) && isNotSulfuras(item)
        if (isExpired && hasAnExpirationDate) {
            val expirationMultiplier = 2
            item.quality -= qualityDecrease * expirationMultiplier
            return
        }
        if (hasAnExpirationDate) {
            item.quality -= qualityDecrease
        }
    }

    private fun increaseQuality(item: Item) {
        val maxQuality = 50
        val isNotTheMaximumQuality = item.quality < maxQuality
        val itHasTheMaximumQuality = item.quality == maxQuality
        if (itHasTheMaximumQuality) return
        val qualityIncrease = 1

        if (isABackstagePass(item)) {
            item.quality += qualityIncrease
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
            decreaseSellIn(item)
            return
        }

        if (isAgedBrie(item)) {
            item.quality += qualityIncrease
            decreaseSellIn(item)
            val isExpired = isExpired(item)
            if (isExpired && isNotTheMaximumQuality) {
                item.quality += qualityIncrease
            }
            return
        }
        decreaseSellIn(item)
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
