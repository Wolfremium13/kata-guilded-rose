import dev.wolfremium.www.*
import dev.wolfremium.www.items.AgedBrie
import dev.wolfremium.www.items.BackstagePass
import dev.wolfremium.www.items.DefaultItem
import dev.wolfremium.www.items.Sulfuras
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class GildedRoseShould {
    @Test
    fun `decrease quality when the item is still on the number of days to be sold`() {
        val goods = listOf(DefaultItem("", 1, 1))
        val app = GildedRose(goods)

        app.updateQuality()

        assertThat(app.items[0].currentQuality()).isEqualTo(0)
    }

    @Test
    fun `decrease quality twice as fast when the item is past the number of days to be sold`() {
        val goods = listOf(DefaultItem("", 0, 2))
        val app = GildedRose(goods)

        app.updateQuality()

        assertThat(app.items[0].currentQuality()).isEqualTo(0)
    }

    @Test
    fun `never decrease quality below zero`() {
        val goods = listOf(DefaultItem("", 0, 0))
        val app = GildedRose(goods)

        app.updateQuality()

        assertThat(app.items[0].currentQuality()).isEqualTo(0)
    }

    @Test
    fun `increase quality of Aged Brie when the item is still on the number of days to be sold`() {
        val goods = listOf(AgedBrie("Aged Brie", 1, 1))
        val app = GildedRose(goods)

        app.updateQuality()

        assertThat(app.items[0].currentQuality()).isEqualTo(2)
    }


    @Test
    fun `increase quality of Aged Brie twice as fast when the item is past the number of days to be sold`() {
        val goods = listOf(AgedBrie("Aged Brie", 0, 1))
        val app = GildedRose(goods)

        app.updateQuality()

        assertThat(app.items[0].currentQuality()).isEqualTo(3)
    }

    @Test
    fun `never increase quality of Aged Brie above 50`() {
        val goods = listOf(AgedBrie("Aged Brie", 0, 50))
        val app = GildedRose(goods)

        app.updateQuality()

        assertThat(app.items[0].currentQuality()).isEqualTo(50)
    }

    @Test
    fun `never decrease quality of Sulfuras`() {
        val goods = listOf(Sulfuras("Sulfuras, Hand of Ragnaros", 0, 1))
        val app = GildedRose(goods)

        app.updateQuality()

        assertThat(app.items[0].currentQuality()).isEqualTo(1)
    }

    @Test
    fun `increase quality of Backstage passes by 1 when the item is still on the number of days to be sold and the number of days to be sold is greater than 10`() {
        val goods = listOf(BackstagePass("Backstage passes to a TAFKAL80ETC concert", 11, 1))
        val app = GildedRose(goods)

        app.updateQuality()

        assertThat(app.items[0].currentQuality()).isEqualTo(2)
    }

    @Test
    fun `increase quality of Backstage passes by 2 when the item is still on the number of days to be sold and the number of days to be sold is between 10 and 6`() {
        val goods = listOf(BackstagePass("Backstage passes to a TAFKAL80ETC concert", 10, 1))
        val app = GildedRose(goods)

        app.updateQuality()

        assertThat(app.items[0].currentQuality()).isEqualTo(3)
    }

    @Test
    fun `increase quality of Backstage passes by 3 when the item is still on the number of days to be sold and the number of days to be sold is between 5 and 1`() {
        val goods = listOf(BackstagePass("Backstage passes to a TAFKAL80ETC concert", 5, 1))
        val app = GildedRose(goods)

        app.updateQuality()

        assertThat(app.items[0].currentQuality()).isEqualTo(4)
    }

    @Test
    fun `set quality of Backstage passes to 0 when the item is still on the number of days to be sold and the number of days to be sold is 0`() {
        val goods = listOf(BackstagePass("Backstage passes to a TAFKAL80ETC concert", 0, 1))
        val app = GildedRose(goods)

        app.updateQuality()

        assertThat(app.items[0].currentQuality()).isEqualTo(0)
    }


}