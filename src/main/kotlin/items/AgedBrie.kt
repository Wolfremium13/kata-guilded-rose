package dev.wolfremium.www.items

class AgedBrie(name: String, sellIn: Int, quality: Int) : Item(name, sellIn, quality) {
    override fun updateQuality() {
        if (hadMaximumQuality()) return
        increaseQuality()
        if (isExpired() && !hadMaximumQuality()) {
            increaseQuality()
        }
    }

    override fun decreaseSellIn() {
        sellIn -= dayDecrease
    }

    override fun currentQuality(): Int {
        return quality
    }

    private fun isExpired(): Boolean {
        return sellIn <= 0
    }

    private fun increaseQuality() {
        quality += qualityIncrease
    }

    private fun hadMaximumQuality(): Boolean {
        return quality == maxQuality
    }
}