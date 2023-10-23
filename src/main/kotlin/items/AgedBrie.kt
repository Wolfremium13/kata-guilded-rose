package dev.wolfremium.www.items

import dev.wolfremium.www.item.Item

class AgedBrie(name: String, sellIn: Int, quality: Int) : Item(name, sellIn, quality) {
    override fun updateQuality() {
        if (hadMaximumQuality()) return
        increaseQuality()
        if (isExpired() && !hadMaximumQuality()) {
            increaseQuality()
        }
    }

    override fun decreaseDaysLeft() {
        daysLeft -= dayDecrease
    }

    override fun currentQuality(): Int {
        return quality
    }

    private fun isExpired(): Boolean {
        return daysLeft <= 0
    }

    private fun increaseQuality() {
        quality += qualityIncrease
    }

    private fun hadMaximumQuality(): Boolean {
        return quality == maxQuality
    }
}