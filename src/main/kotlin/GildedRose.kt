package dev.wolfremium.www

import dev.wolfremium.www.item.Item

class GildedRose(var items: List<Item>) {
    fun updateQuality() {
        items.forEach { item ->
            item.updateQuality()
            item.decreaseDaysLeft()
        }
    }
}
