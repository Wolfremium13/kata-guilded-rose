package dev.wolfremium.www.item

class ItemQuality private constructor(private var value: Int) {
    private val minimumQuality = 0
    private val maximumQuality = 50
    private val qualityIncrease = 1
    private val qualityDecrease = 1

    companion object {
        fun create(value: Int): ItemQuality {
            val minimumQuality = 0
            val maximumQuality = 50
            if (value in minimumQuality..maximumQuality) return ItemQuality(value)
            throw IllegalArgumentException("Quality must be between $minimumQuality and $maximumQuality")
        }
    }

    fun increase(times: Int = 1) {
        if (value + qualityIncrease * times >= maximumQuality) {
            value = maximumQuality
            return
        }
        value += qualityIncrease * times
    }

    fun decrease(times: Int = 1) {
        if (value - qualityDecrease * times < minimumQuality) {
            value = minimumQuality
            return
        }
        value -= qualityDecrease * times
    }

    fun isMaximum(): Boolean {
        return value == maximumQuality
    }

    fun value(): Int {
        return value
    }

    fun maximum(): Int {
        return maximumQuality
    }

    fun minimum(): Int {
        return minimumQuality
    }
}