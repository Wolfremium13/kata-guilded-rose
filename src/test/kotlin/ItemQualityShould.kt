import dev.wolfremium.www.item.ItemQuality
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ItemQualityShould {

    @Test
    fun `not allow to create a quality with value less than minimum`() {
        val minimumQuality = 0
        val quality = minimumQuality - 1

        assertThrows<IllegalArgumentException> {
            ItemQuality.create(quality)
        }
    }

    @Test
    fun `not allow to create a quality with value greater than maximum`() {
        val maximumQuality = 50
        val quality = maximumQuality + 1

        assertThrows<IllegalArgumentException> {
            ItemQuality.create(quality)
        }
    }

    @Test
    fun `allow to create a quality with value between minimum and maximum`() {
        val minimumQuality = 0
        val maximumQuality = 50
        val quality = (maximumQuality - minimumQuality) / 2

        ItemQuality.create(quality)
    }

}


