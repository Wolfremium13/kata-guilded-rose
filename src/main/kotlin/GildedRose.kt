package dev.wolfremium.www

class GildedRose(var items: List<Item>) {
    fun updateQuality() {
        for (item in items) {
          updateQuality(item)
        }
    }

    private fun updateQuality(item: Item) {
        if (item.name == "Sulfuras, Hand of Ragnaros") {
            return
        }

        if (item.name == "Backstage passes to a TAFKAL80ETC concert") {
            if (item.quality < 50) {
                item.quality = item.quality + 1
            }

            if (item.sellIn < 11) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1
                }
            }

           item.sellIn = item.sellIn - 1

            if (item.sellIn < 0) {
                item.quality = 0
            }

            return
        }

        if (item.name == "Aged Brie") {
            if (item.quality < 50) {
                item.quality = item.quality + 1
            }
            item.sellIn = item.sellIn - 1

            if (item.sellIn < 0) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1
                }
            }
            return
        }

        if (item.quality > 0) {
            item.quality = item.quality - 1
        }

        item.sellIn = item.sellIn - 1

        if (item.sellIn < 0) {

            if (item.quality > 0) {
                item.quality = item.quality - 1
            }
        }
    }
}
