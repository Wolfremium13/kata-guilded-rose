import dev.wolfremium.www.item.DaysLeft
import dev.wolfremium.www.item.Item
import dev.wolfremium.www.item.ItemName
import dev.wolfremium.www.item.ItemQuality
import dev.wolfremium.www.items.*

class ItemFactory {
    companion object {
        fun createItem(itemName: ItemName, daysLeft: DaysLeft, quality: ItemQuality): Item {
            return when (itemName.value()) {
                "Aged Brie" -> AgedBrie(itemName, daysLeft, quality)
                "Backstage passes to a TAFKAL80ETC concert" -> BackstagePass(itemName, daysLeft, quality)
                "Sulfuras, Hand of Ragnaros" -> Sulfuras(itemName, daysLeft, quality)
                "Conjured" -> Conjured(itemName, daysLeft, quality)
                else -> DefaultItem(itemName, daysLeft, quality)
            }
        }
    }
}