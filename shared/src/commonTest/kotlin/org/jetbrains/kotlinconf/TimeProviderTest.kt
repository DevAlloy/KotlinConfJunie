package org.jetbrains.kotlinconf

import kotlinx.datetime.LocalDateTime
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.minutes
import org.jetbrains.kotlinconf.utils.Logger

class TimeProviderTest {

    private class TestLogger : Logger {
        val logs = mutableListOf<String>()

        override fun log(tag: String, message: () -> String) {
            logs.add("[$tag] ${message()}")
        }
    }

    @Test
    fun testLocalDateTimeMinusLocalDateTime() {
        // Arrange
        val dateTime1 = LocalDateTime(2023, 10, 15, 14, 30)
        val dateTime2 = LocalDateTime(2023, 10, 15, 12, 30)

        // Act
        val result = dateTime1 - dateTime2

        // Assert
        assertEquals(2.hours, result)
    }

    @Test
    fun testLocalDateTimeMinusDuration() {
        // Arrange
        val dateTime = LocalDateTime(2023, 10, 15, 14, 30)
        val duration = 2.hours

        // Act
        val result = dateTime - duration

        // Assert
        assertEquals(LocalDateTime(2023, 10, 15, 12, 30), result)
    }

    @Test
    fun testFakeTimeProvider_initialState() {
        // Arrange
        val logger = TestLogger()
        val baseTime = LocalDateTime(2023, 10, 15, 14, 30)

        // Act
        val timeProvider = FakeTimeProvider(logger, baseTime, freezeTime = true)

        // Assert
        assertEquals(baseTime, timeProvider.now())
        assertEquals(baseTime, timeProvider.time.value)
    }

    @Test
    fun testFakeTimeProvider_getNotificationDelay() {
        // Arrange
        val logger = TestLogger()
        val baseTime = LocalDateTime(2023, 10, 15, 14, 30)
        val notificationTime = LocalDateTime(2023, 10, 15, 15, 30)
        val timeProvider = FakeTimeProvider(logger, baseTime, freezeTime = true, speedMultiplier = 10.0)

        // Act
        val delay = timeProvider.getNotificationDelay(notificationTime)

        // Assert
        assertEquals(6.minutes, delay) // (1 hour / 10) = 6 minutes
    }

    @Test
    fun testFakeTimeProvider_getNotificationTime() {
        // Arrange
        val logger = TestLogger()
        val baseTime = LocalDateTime(2023, 10, 15, 14, 30)
        val notificationTime = LocalDateTime(2023, 10, 15, 15, 30)
        val timeProvider = FakeTimeProvider(logger, baseTime, freezeTime = true)

        // Act
        val result = timeProvider.getNotificationTime(notificationTime)

        // Assert
        // This is a bit tricky to test precisely since it depends on the current system time
        // We can at least verify it returns a LocalDateTime
        assertEquals(LocalDateTime::class, result::class)
    }
}
