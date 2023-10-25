import dev.wolfremium.www.item.DaysLeft
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class DaysLeftShould {

    @Test
    fun `not allows to create a days left with value less than minimum`() {
        val minimumDaysLeft = 0
        val daysLeft = minimumDaysLeft - 1

        assertThrows<IllegalArgumentException> {
            DaysLeft.create(daysLeft)
        }
    }

}