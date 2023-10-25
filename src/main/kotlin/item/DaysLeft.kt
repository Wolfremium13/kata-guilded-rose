package dev.wolfremium.www.item

class DaysLeft private constructor(private val daysLeft: Int)
{
    private val dayDecrease = 1
    companion object {
        fun create(value: Int): DaysLeft {
            val isPositive = value >= 0
            if (isPositive) return DaysLeft(value)
            throw IllegalArgumentException("Days left cannot be negative")
        }
    }

    fun decrease(): DaysLeft {
        return DaysLeft(daysLeft - dayDecrease)
    }

    fun areOver(): Boolean {
        return daysLeft <= 0
    }

    fun value(): Int {
        return daysLeft
    }
}