package dev.wolfremium.www

class AgedBrieUpdater : ItemUpdater() {
    override fun updateQuality(item: Item) {
        if (hadMaximumQuality(item)) return
        increaseQuality(item)
        if (isExpired(item) && !hadMaximumQuality(item)) {
            increaseQuality(item)
        }
    }

    override fun decreaseSellIn(item: Item) {
        item.sellIn -= dayDecrease
    }

    private fun isExpired(item: Item): Boolean {
        return item.sellIn <= 0
    }

    private fun increaseQuality(item: Item) {
        item.quality += qualityIncrease
    }

    private fun hadMaximumQuality(item: Item): Boolean {
        return item.quality == maxQuality
    }


}