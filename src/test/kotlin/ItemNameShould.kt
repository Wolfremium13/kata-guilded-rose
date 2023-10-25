import dev.wolfremium.www.item.ItemName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ItemNameShould {

    @Test
    fun `not allows to create an empty name`() {
        val name = ""

        assertThrows<IllegalArgumentException> {
            ItemName.create(name)
        }
    }

}