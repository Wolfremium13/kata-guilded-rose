package dev.wolfremium.www

class DefaultItemUpdater : ItemUpdater() {
    override fun updateQuality(item: Item) {
        if (hadQuality(item)) {
            decreaseQuality(item)
        }
        if (isExpired(item) && hadQuality(item)) {
            decreaseQuality(item)
        }
    }

    override fun decreaseSellIn(item: Item) {
        item.sellIn -= dayDecrease
    }

    private fun isExpired(item: Item): Boolean {
        return item.sellIn <= 0
    }

    private fun hadQuality(item: Item): Boolean {
        return item.quality > minQuality
    }

    private fun decreaseQuality(item: Item) {
        item.quality -= this.qualityDecrease
    }

}