package dev.wolfremium.www.item

abstract class Item(protected val name: String, protected var daysLeft: Int, protected var quality: Int) {
    protected val minQuality = 0
    protected val maxQuality = 50
    protected val qualityIncrease = 1
    protected val qualityDecrease = 1
    protected val dayDecrease = 1
    abstract fun updateQuality()
    abstract fun decreaseDaysLeft()
    abstract fun currentQuality(): Int
}