package dev.wolfremium.www.item

class ItemName private constructor(private val value: String) {
    companion object {
        fun create(value: String): ItemName {
            if (value.isNotBlank()) return ItemName(value)
            throw IllegalArgumentException("Item name cannot be blank")
        }
    }

    fun value(): String {
        return value
    }
}
