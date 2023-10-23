package dev.wolfremium.www.items

import dev.wolfremium.www.item.Item

class Sulfuras(name: String, sellIn: Int, quality: Int) : Item(name, sellIn, quality) {
    override fun updateQuality() {
        // Nothing to do
    }

    override fun decreaseDaysLeft() {
        // Nothing to do
    }

    override fun currentQuality(): Int {
        return quality
    }
}