package dev.wolfremium.www

class GildedRose(var items: List<Item>) {
    private val itemUpdaterFactory = ItemUpdaterFactory()

    fun updateQuality() {
        items.forEach { item ->
            val updater = itemUpdaterFactory.getUpdater(item)
            updater.updateQuality(item)
            updater.decreaseSellIn(item)
        }
    }
}
