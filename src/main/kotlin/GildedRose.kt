package dev.wolfremium.www

class GildedRose(var items: List<Item>) {
    fun updateQuality() {
        items.forEach { item ->
            val updater = when (item.name) {
                "Aged Brie" -> AgedBrieUpdater()
                "Backstage passes to a TAFKAL80ETC concert" -> BackstagePassUpdater()
                "Sulfuras, Hand of Ragnaros" -> SulfurasUpdater()
                else -> DefaultItemUpdater()
            }
            updater.updateQuality(item)
            updater.decreaseSellIn(item)
        }
    }
}
