import dev.wolfremium.www.item.Item
import dev.wolfremium.www.items.AgedBrie
import dev.wolfremium.www.items.BackstagePass
import dev.wolfremium.www.items.DefaultItem
import dev.wolfremium.www.items.Sulfuras

class ItemFactory {
    companion object {
        fun createItem(name: String, sellIn: Int, quality: Int): Item {
            return when (name) {
                "Aged Brie" -> AgedBrie(name, sellIn, quality)
                "Backstage passes to a TAFKAL80ETC concert" -> BackstagePass(name, sellIn, quality)
                "Sulfuras, Hand of Ragnaros" -> Sulfuras(name, sellIn, quality)
                else -> DefaultItem(name, sellIn, quality)
            }
        }
    }
}