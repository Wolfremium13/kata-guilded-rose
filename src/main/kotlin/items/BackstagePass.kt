package dev.wolfremium.www.items

import dev.wolfremium.www.item.Item

class BackstagePass(name: String, sellIn: Int, quality: Int) : Item(name, sellIn, quality) {
    override fun updateQuality() {
        when {
            thereAreALotOfTimeLeft() -> quality += 1
            isNearToTheLastWeek() -> quality += 2
            isOnLastDays() -> quality += 3
            else -> quality = 0
        }
    }

    override fun decreaseDaysLeft() {
        daysLeft -= dayDecrease
    }

    override fun currentQuality(): Int {
        return quality
    }

    private fun thereAreALotOfTimeLeft() = daysLeft > 10 && quality < 50

    private fun isNearToTheLastWeek() = daysLeft in 6..10 && quality <= maxQuality - 2

    private fun isOnLastDays() = daysLeft in 1..5 && quality <= maxQuality - 3
}