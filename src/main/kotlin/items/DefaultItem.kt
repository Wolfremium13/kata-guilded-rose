package dev.wolfremium.www.items

class DefaultItem(name: String, sellIn: Int, quality: Int) : Item(name, sellIn, quality) {
    override fun updateQuality() {
        if (hadQuality()) {
            decreaseQuality()
        }
        if (isExpired() && hadQuality()) {
            decreaseQuality()
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

    private fun hadQuality(): Boolean {
        return quality > minQuality
    }

    private fun decreaseQuality() {
        quality -= this.qualityDecrease
    }
}