package dev.wolfremium.www

abstract class ItemUpdater {
    protected val minQuality = 0
    protected val maxQuality = 50
    protected val qualityIncrease = 1
    protected val qualityDecrease = 1
    protected val dayDecrease = 1

    abstract fun updateQuality(item: Item)
    abstract fun decreaseSellIn(item: Item)

}