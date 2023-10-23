package dev.wolfremium.www.items

import dev.wolfremium.www.item.Item

class BackstagePass(name: String, sellIn: Int, quality: Int) : Item(name, sellIn, quality) {
    override fun updateQuality() {
        when {
            isOnMaximumQuality() -> quality = maxQuality
            thereAreALotOfTimeLeft() -> increaseQuality()
            isNearToTheLastWeek() -> increaseQuality(2)
            isOnLastDays() -> increaseQuality(3)
            else -> quality = minQuality
        }
    }

    private fun isOnMaximumQuality(): Boolean {
        return quality == maxQuality
    }

    override fun decreaseDaysLeft() {
        daysLeft -= dayDecrease
    }

    override fun currentQuality(): Int {
        return quality
    }

    private fun thereAreALotOfTimeLeft() = daysLeft > 10 && quality < maxQuality

    private fun isNearToTheLastWeek() = daysLeft in 6..10 && quality <= maxQuality - 2

    private fun isOnLastDays() = daysLeft in 1..5 && quality <= maxQuality - 3

    private fun increaseQuality(times: Int = 1) {
        quality += qualityIncrease * times
    }
}