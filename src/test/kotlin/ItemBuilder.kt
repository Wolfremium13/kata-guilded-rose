import dev.wolfremium.www.item.Item

class ItemBuilder {
    private var name: String = ""
    private var daysLeft: Int = 1
    private var quality: Int = 0

    fun build(): Item {
        return ItemFactory.createItem(name, daysLeft, quality)
    }

    fun withName(name: String): ItemBuilder {
        this.name = name
        return this
    }

    fun withDaysLeft(daysLeft: Int): ItemBuilder {
        this.daysLeft = daysLeft
        return this
    }

    fun withQuality(quality: Int): ItemBuilder {
        this.quality = quality
        return this
    }
}