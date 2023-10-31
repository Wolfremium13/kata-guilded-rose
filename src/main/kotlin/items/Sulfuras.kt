package dev.wolfremium.www.items

import dev.wolfremium.www.item.DaysLeft
import dev.wolfremium.www.item.Item
import dev.wolfremium.www.item.ItemName
import dev.wolfremium.www.item.ItemQuality

class Sulfuras(
    name: ItemName,
    daysLeft: DaysLeft,
    quality: ItemQuality
) : Item(
    name, daysLeft, quality
) {
    override fun updateQuality() {
        // Nothing to do
    }

    override fun decreaseDaysLeft() {
        // Nothing to do
    }

    override fun currentQuality(): Int {
        val legendaryQuality = 80
        return legendaryQuality
    }
}