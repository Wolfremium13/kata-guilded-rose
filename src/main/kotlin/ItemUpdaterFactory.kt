package dev.wolfremium.www

class ItemUpdaterFactory {
    fun getUpdater(item: Item): ItemUpdater {
        return when(item.name) {
            "Aged Brie" -> AgedBrieUpdater()
            "Backstage passes to a TAFKAL80ETC concert" -> BackstagePassUpdater()
            "Sulfuras, Hand of Ragnaros" -> SulfurasUpdater()
            else -> DefaultItemUpdater()
        }
    }
}