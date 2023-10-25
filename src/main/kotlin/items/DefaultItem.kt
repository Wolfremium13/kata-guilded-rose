package dev.wolfremium.www.items

import dev.wolfremium.www.item.DaysLeft
import dev.wolfremium.www.item.Item
import dev.wolfremium.www.item.ItemName
import dev.wolfremium.www.item.ItemQuality

class DefaultItem(
    name: ItemName,
    daysLeft: DaysLeft,
    quality: ItemQuality
) : Item(
    name, daysLeft, quality
) {
    override fun updateQuality() {
        quality.decrease()
        if (daysLeft.areOver()) {
            quality.decrease()
        }
    }

    override fun decreaseDaysLeft() {
        daysLeft.decrease()
    }

    override fun currentQuality(): Int {
        return quality.value()
    }
}