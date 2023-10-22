package dev.wolfremium.www.items

class Sulfuras(name: String, sellIn: Int, quality: Int) : Item(name, sellIn, quality) {
    override fun updateQuality() {
        // Nothing to do
    }

    override fun decreaseSellIn() {
        // Nothing to do
    }

    override fun currentQuality(): Int {
        return quality
    }
}