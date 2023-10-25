package dev.wolfremium.www.item

abstract class Item(
    protected val name: ItemName,
    protected var daysLeft: DaysLeft,
    protected var quality: ItemQuality
) {
    abstract fun updateQuality()
    abstract fun decreaseDaysLeft()
    abstract fun currentQuality(): Int
}