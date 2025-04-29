package org.jetbrains.kotlinconf

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue
import kotlin.test.assertFalse

class ModelTest {
    
    @Test
    fun testScoreFromValue() {
        // Arrange & Act & Assert
        assertEquals(Score.GOOD, Score.fromValue(1))
        assertEquals(Score.OK, Score.fromValue(0))
        assertEquals(Score.BAD, Score.fromValue(-1))
        assertNull(Score.fromValue(2))
        assertNull(Score.fromValue(-2))
    }
    
    @Test
    fun testNotificationSettingsHasAnyEnabled_allDisabled() {
        // Arrange
        val settings = NotificationSettings(
            sessionReminders = false,
            scheduleUpdates = false,
            kotlinConfNews = false,
            jetBrainsNews = false
        )
        
        // Act
        val result = settings.hasAnyEnabled()
        
        // Assert
        assertFalse(result)
    }
    
    @Test
    fun testNotificationSettingsHasAnyEnabled_sessionRemindersEnabled() {
        // Arrange
        val settings = NotificationSettings(
            sessionReminders = true,
            scheduleUpdates = false,
            kotlinConfNews = false,
            jetBrainsNews = false
        )
        
        // Act
        val result = settings.hasAnyEnabled()
        
        // Assert
        assertTrue(result)
    }
    
    @Test
    fun testNotificationSettingsHasAnyEnabled_scheduleUpdatesEnabled() {
        // Arrange
        val settings = NotificationSettings(
            sessionReminders = false,
            scheduleUpdates = true,
            kotlinConfNews = false,
            jetBrainsNews = false
        )
        
        // Act
        val result = settings.hasAnyEnabled()
        
        // Assert
        assertTrue(result)
    }
    
    @Test
    fun testNotificationSettingsHasAnyEnabled_kotlinConfNewsEnabled() {
        // Arrange
        val settings = NotificationSettings(
            sessionReminders = false,
            scheduleUpdates = false,
            kotlinConfNews = true,
            jetBrainsNews = false
        )
        
        // Act
        val result = settings.hasAnyEnabled()
        
        // Assert
        assertTrue(result)
    }
    
    @Test
    fun testNotificationSettingsHasAnyEnabled_jetBrainsNewsEnabled() {
        // Arrange
        val settings = NotificationSettings(
            sessionReminders = false,
            scheduleUpdates = false,
            kotlinConfNews = false,
            jetBrainsNews = true
        )
        
        // Act
        val result = settings.hasAnyEnabled()
        
        // Assert
        assertTrue(result)
    }
    
    @Test
    fun testNotificationSettingsHasAnyEnabled_allEnabled() {
        // Arrange
        val settings = NotificationSettings(
            sessionReminders = true,
            scheduleUpdates = true,
            kotlinConfNews = true,
            jetBrainsNews = true
        )
        
        // Act
        val result = settings.hasAnyEnabled()
        
        // Assert
        assertTrue(result)
    }
}