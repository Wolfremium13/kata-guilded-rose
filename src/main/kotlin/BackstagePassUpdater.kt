package dev.wolfremium.www

class BackstagePassUpdater : ItemUpdater() {
    override fun updateQuality(item: Item) {
        when {
            thereAreALotOfTimeLeft(item) -> item.quality += 1
            isNearToTheLastWeek(item) -> item.quality += 2
            isOnLastDays(item) -> item.quality += 3
            else -> item.quality = 0
        }
    }

    override fun decreaseSellIn(item: Item) {
        item.sellIn -= dayDecrease
    }

    private fun thereAreALotOfTimeLeft(item: Item) = item.sellIn > 10 && item.quality < 50

    private fun isNearToTheLastWeek(item: Item) = item.sellIn in 6..10 && item.quality <= maxQuality - 2

    private fun isOnLastDays(item: Item) = item.sellIn in 1..5 && item.quality <= maxQuality - 3

}