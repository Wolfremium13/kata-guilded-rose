package dev.wolfremium.www.items

import dev.wolfremium.www.item.DaysLeft
import dev.wolfremium.www.item.Item
import dev.wolfremium.www.item.ItemName
import dev.wolfremium.www.item.ItemQuality

class Conjured(
    name: ItemName,
    daysLeft: DaysLeft,
    quality: ItemQuality
) : Item(
    name, daysLeft, quality
) {
    override fun updateQuality() {
        quality.decrease(2)
        if (daysLeft.areOver()) {
            quality.decrease(2)
        }
    }

    override fun decreaseDaysLeft() {
        daysLeft.decrease()
    }

    override fun currentQuality(): Int {
        return quality.value()
    }
}