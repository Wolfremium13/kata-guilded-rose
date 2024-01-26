import dev.wolfremium.www.GildedRose
import dev.wolfremium.www.Item
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class GildedRoseShould {
    // The system cannot support out of edge inputs

    @ParameterizedTest(name = "quality of {0} cannot be negative")
    @ValueSource(
        strings = [
            "Backstage passes to a TAFKAL80ETC concert",
            "DefaultItem"
        ]
    )
    fun `quality cannot be negative`(itemName: String) {
        val item = Item(name = itemName, sellIn = 0, quality = 0)
        val shop = GildedRose(listOf(item))

        shop.updateQuality()

        assertThat(shop.items[0].quality).isEqualTo(0)
    }

    @Test
    fun `Aged Brie quality cannot be higher than the maximum`() {
        val MAXIMUM_QUALITY = 50
        val item = Item(name = "Aged Brie", sellIn = -1, quality = MAXIMUM_QUALITY)
        val shop = GildedRose(listOf(item))

        shop.updateQuality()

        assertThat(shop.items[0].quality).isEqualTo(MAXIMUM_QUALITY)
    }

    @Test
    fun `not allow higher than the maximum quality for Backstage passes`() {
        val item = Item(name = "Backstage passes to a TAFKAL80ETC concert", sellIn = 2, quality = 50)
        val shop = GildedRose(listOf(item))

        shop.updateQuality()

        assertThat(shop.items[0].quality).isEqualTo(50)
    }

    @Test
    fun `not allow change the quality of Sulfuras`() {
        val item = Item(name = "Sulfuras, Hand of Ragnaros", sellIn = 1, quality = 80)
        val shop = GildedRose(listOf(item))

        shop.updateQuality()

        assertThat(shop.items[0].quality).isEqualTo(80)
    }

    @Test
    fun `allow to change the quality of Backstage passes`(){
        val item = Item(name = "Backstage passes to a TAFKAL80ETC concert", sellIn = 0, quality = 50)
        val shop = GildedRose(listOf(item))

        shop.updateQuality()

        assertThat(shop.items[0].quality).isEqualTo(0)
        assertThat(shop.items[0].sellIn).isEqualTo(-1)
    }

    @Test
    fun `decrease twice time faster the expired items` (){
        val item = Item(name = "DefaultIteam", sellIn = 0, quality = 50)
        val shop = GildedRose(listOf(item))

        shop.updateQuality()

        assertThat(shop.items[0].quality).isEqualTo(48)
        assertThat(shop.items[0].sellIn).isEqualTo(-1)
    }

}