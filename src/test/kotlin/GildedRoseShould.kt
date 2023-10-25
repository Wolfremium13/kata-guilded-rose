import dev.wolfremium.www.GildedRose
import dev.wolfremium.www.item.Item
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

// It's here because of parameterized tests
const val agedBrieItemName = "Aged Brie"
const val backstagePassItemName = "Backstage passes to a TAFKAL80ETC concert"
const val sulfurasItemName = "Sulfuras, Hand of Ragnaros"
const val defaultItemName = "default item"

class GildedRoseShould {
    private val qualityDecrease = 1
    private val qualityIncrease = 1

    @Test
    fun `on default item decrease quality on default`() {
        val initialQuality = 1
        val defaultItem = ItemBuilder().withQuality(initialQuality).build()
        val app = this.createGildedRoseApp(listOf(defaultItem))

        app.updateQuality()

        val defaultQuality = app.items[0].currentQuality()
        assertThat(defaultQuality).isEqualTo(initialQuality - qualityDecrease)
    }

    @Test
    fun `on default item decrease quality twice as fast when is expired`() {
        val initialQuality = 2
        val noDaysLeft = 0
        val defaultItem = ItemBuilder().withDaysLeft(noDaysLeft).withQuality(initialQuality).build()
        val app = this.createGildedRoseApp(listOf(defaultItem))

        app.updateQuality()

        val defaultQuality = app.items[0].currentQuality()
        assertThat(defaultQuality).isEqualTo(initialQuality - (qualityDecrease * 2))
    }

    @ParameterizedTest(name = "on {0} never decrease quality below zero")
    @ValueSource(
        strings = [
            backstagePassItemName,
            sulfurasItemName,
            defaultItemName
        ]
    )
    fun `items that could decrease quality when expired`(itemName: String) {
        val noQuality = 0
        val noDaysLeft = 0
        val expiredItem = ItemBuilder().withName(itemName).withDaysLeft(noDaysLeft).withQuality(noQuality).build()
        val app = this.createGildedRoseApp(listOf(expiredItem))

        app.updateQuality()

        val expiredQuality = app.items[0].currentQuality()
        assertThat(expiredQuality).isEqualTo(noQuality)
    }

    @Test
    fun `increase quality of Aged Brie when is not expired`() {
        val onLastDay = 1
        val fewQuality = 1
        val agedBrie = ItemBuilder().withName(agedBrieItemName).withDaysLeft(onLastDay).withQuality(fewQuality).build()
        val app = this.createGildedRoseApp(listOf(agedBrie))

        app.updateQuality()

        val agedBrieQuality = app.items[0].currentQuality()
        assertThat(agedBrieQuality).isEqualTo(fewQuality + qualityIncrease)
    }


    @Test
    fun `increase quality twice fast of Aged Brie when is expired`() {
        val noDaysLeft = 0
        val mediumQuality = 2
        val agedBrie =
            ItemBuilder().withName(agedBrieItemName).withDaysLeft(noDaysLeft).withQuality(mediumQuality).build()
        val app = this.createGildedRoseApp(listOf(agedBrie))

        app.updateQuality()

        val agedBrieQuality = app.items[0].currentQuality()
        assertThat(agedBrieQuality).isEqualTo(mediumQuality + (qualityIncrease * 2))
    }

    @ParameterizedTest(name = "on {0} never could be above maximum quality")
    @ValueSource(
        strings = [
            agedBrieItemName,
            backstagePassItemName,
        ]
    )
    fun `items that increases quality`(itemName: String) {
        val maximumQuality = 50
        val fewDays = 2
        val app = this.createGildedRoseApp(
            listOf(
                ItemBuilder().withName(itemName).withQuality(maximumQuality).withDaysLeft(
                    fewDays
                ).build()
            )
        )

        app.updateQuality()

        val itemQuality = app.items[0].currentQuality()
        assertThat(itemQuality).isEqualTo(maximumQuality)
    }

    @Test
    fun `never change quality of Sulfuras`() {
        val initialQuality = 10
        val app = this.createGildedRoseApp(
            listOf(
                ItemBuilder().withName(sulfurasItemName).withQuality(initialQuality).build()
            )
        )

        app.updateQuality()

        val sulfurasQuality = app.items[0].currentQuality()
        assertThat(sulfurasQuality).isEqualTo(initialQuality)
    }

    @Test
    fun `backstage passes increases quality when there a lot of time left`() {
        val aLotOfTimeLeft = 11
        val fewQuality = 1
        val app = this.createGildedRoseApp(
            listOf(
                ItemBuilder().withName(backstagePassItemName).withDaysLeft(aLotOfTimeLeft).withQuality(fewQuality)
                    .build()
            )
        )

        app.updateQuality()

        val backstageQuality = app.items[0].currentQuality()
        assertThat(backstageQuality).isEqualTo(fewQuality + qualityIncrease)
    }

    @ParameterizedTest(name = "on {0} left days")
    @ValueSource(
        ints = [
            6,
            7,
            8,
            9,
            10
        ]
    )
    fun `backstage passes increases quality twice when there a near by last week`(nearLastWeek: Int) {
        val initialQuality = 1
        val app = this.createGildedRoseApp(
            listOf(
                ItemBuilder().withName(backstagePassItemName).withDaysLeft(nearLastWeek).withQuality(initialQuality)
                    .build()
            )
        )

        app.updateQuality()

        val backstageQuality = app.items[0].currentQuality()
        assertThat(backstageQuality).isEqualTo(initialQuality + (qualityIncrease * 2))
    }

    @Test
    fun `back stage passes cannot be sold when is expired`() {
        val highQuality = 10
        val noDaysLeft = 0
        val app = this.createGildedRoseApp(
            listOf(
                ItemBuilder().withName(backstagePassItemName).withDaysLeft(noDaysLeft).withQuality(highQuality).build()
            )
        )

        app.updateQuality()

        val backstageQuality = app.items[0].currentQuality()
        val noQuality = 0
        assertThat(backstageQuality).isEqualTo(noQuality)
    }

    private fun createGildedRoseApp(items: List<Item>): GildedRose {
        return GildedRose(items)
    }

}