package dev.wolfremium.www.items

class BackstagePass(name: String, sellIn: Int, quality: Int) : Item(name, sellIn, quality) {
    override fun updateQuality() {
        when {
            thereAreALotOfTimeLeft() -> quality += 1
            isNearToTheLastWeek() -> quality += 2
            isOnLastDays() -> quality += 3
            else -> quality = 0
        }
    }

    override fun decreaseSellIn() {
        sellIn -= dayDecrease
    }

    override fun currentQuality(): Int {
        return quality
    }

    private fun thereAreALotOfTimeLeft() = sellIn > 10 && quality < 50

    private fun isNearToTheLastWeek() = sellIn in 6..10 && quality <= maxQuality - 2

    private fun isOnLastDays() = sellIn in 1..5 && quality <= maxQuality - 3
}