package dev.wolfremium.www

class GildedRose(var items: List<Item>) {
    fun updateQuality() {
        for (item in items) {
          updateQuality(item)
        }
    }

    private fun updateQuality(item: Item) {
        when (item.name) {
            "Sulfuras, Hand of Ragnaros" -> {
            }
            "Backstage passes to a TAFKAL80ETC concert" -> {
                updateBackstage(item)
            }
            "Aged Brie" -> {
                updateAgedBrie(item)
            }
            else -> updateNormal(item)
        }
    }

    private fun updateNormal(item: Item) {
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

    private fun updateAgedBrie(item: Item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1
        }
        item.sellIn = item.sellIn - 1

        if (item.sellIn < 0) {
            if (item.quality < 50) {
                item.quality = item.quality + 1
            }
        }
    }

    private fun updateBackstage(item: Item) {
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
    }
}
