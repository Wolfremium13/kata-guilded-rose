import dev.wolfremium.www.item.DaysLeft
import dev.wolfremium.www.item.Item
import dev.wolfremium.www.item.ItemName
import dev.wolfremium.www.item.ItemQuality

class ItemBuilder {
    private var name: ItemName = ItemName.create("Default Item")
    private var daysLeft: DaysLeft = DaysLeft.create(1)
    private var quality: ItemQuality = ItemQuality.create(0)

    fun build(): Item {
        return ItemFactory.createItem(name, daysLeft, quality)
    }

    fun withName(name: String): ItemBuilder {
        this.name = ItemName.create(name)
        return this
    }

    fun withDaysLeft(daysLeft: Int): ItemBuilder {
        this.daysLeft = DaysLeft.create(daysLeft)
        return this
    }

    fun withQuality(quality: Int): ItemBuilder {
        this.quality = ItemQuality.create(quality)
        return this
    }
}