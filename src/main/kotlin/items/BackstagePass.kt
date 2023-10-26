package dev.wolfremium.www.items

import dev.wolfremium.www.item.DaysLeft
import dev.wolfremium.www.item.Item
import dev.wolfremium.www.item.ItemName
import dev.wolfremium.www.item.ItemQuality

class BackstagePass(
    name: ItemName,
    daysLeft: DaysLeft,
    quality: ItemQuality
) : Item(
    name, daysLeft, quality
) {
    override fun updateQuality() {
        when {
            quality.isMaximum() -> quality = ItemQuality.create(quality.maximum())
            thereAreALotOfTimeLeft() -> quality.increase()
            isNearToTheLastWeek() -> quality.increase(2)
            isOnLastDays() -> quality.increase(3)
            else -> quality = ItemQuality.create(quality.minimum())
        }
    }

    override fun decreaseDaysLeft() {
        daysLeft.decrease()
    }

    override fun currentQuality(): Int {
        return quality.value()
    }

    private fun thereAreALotOfTimeLeft() = daysLeft.value() > 10

    private fun isNearToTheLastWeek() = daysLeft.value() in 6..10

    private fun isOnLastDays() = daysLeft.value() in 1..5
}