package org.jetbrains.kotlinconf.utils

import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlin.test.Test
import kotlin.test.assertEquals

class DateTimeFormattingTest {
    
    @Test
    fun testTime() {
        // Arrange
        val dateTime = LocalDateTime(2023, 10, 15, 14, 30)
        
        // Act
        val result = DateTimeFormatting.time(dateTime)
        
        // Assert
        assertEquals("14:30", result)
    }
    
    @Test
    fun testTimeWithSingleDigitHour() {
        // Arrange
        val dateTime = LocalDateTime(2023, 10, 15, 9, 30)
        
        // Act
        val result = DateTimeFormatting.time(dateTime)
        
        // Assert
        assertEquals("09:30", result)
    }
    
    @Test
    fun testTimeWithSingleDigitMinute() {
        // Arrange
        val dateTime = LocalDateTime(2023, 10, 15, 14, 5)
        
        // Act
        val result = DateTimeFormatting.time(dateTime)
        
        // Assert
        assertEquals("14:05", result)
    }
    
    @Test
    fun testDateFromDateTime() {
        // Arrange
        val dateTime = LocalDateTime(2023, 10, 15, 14, 30)
        
        // Act
        val result = DateTimeFormatting.date(dateTime)
        
        // Assert
        assertEquals("October 15", result)
    }
    
    @Test
    fun testDateFromLocalDate() {
        // Arrange
        val date = LocalDate(2023, 10, 15)
        
        // Act
        val result = DateTimeFormatting.date(date)
        
        // Assert
        assertEquals("October 15", result)
    }
    
    @Test
    fun testMonth() {
        // Arrange
        val date = LocalDate(2023, 10, 15)
        
        // Act
        val result = DateTimeFormatting.month(date)
        
        // Assert
        assertEquals("October", result)
    }
    
    @Test
    fun testDateWithYear() {
        // Arrange
        val dateTime = LocalDateTime(2023, 10, 15, 14, 30)
        
        // Act
        val result = DateTimeFormatting.dateWithYear(dateTime)
        
        // Assert
        assertEquals("October 15, 2023", result)
    }
    
    @Test
    fun testTimeToTime() {
        // Arrange
        val start = LocalDateTime(2023, 10, 15, 14, 30)
        val end = LocalDateTime(2023, 10, 15, 15, 45)
        
        // Act
        val result = DateTimeFormatting.timeToTime(start, end)
        
        // Assert
        assertEquals("14:30 – 15:45", result)
    }
    
    @Test
    fun testDateAndTimeWithSingleDateTime() {
        // Arrange
        val dateTime = LocalDateTime(2023, 10, 15, 14, 30)
        
        // Act
        val result = DateTimeFormatting.dateAndTime(dateTime)
        
        // Assert
        assertEquals("October 15, 14:30", result)
    }
    
    @Test
    fun testDateAndTimeWithStartAndEnd() {
        // Arrange
        val start = LocalDateTime(2023, 10, 15, 14, 30)
        val end = LocalDateTime(2023, 10, 15, 15, 45)
        
        // Act
        val result = DateTimeFormatting.dateAndTime(start, end)
        
        // Assert
        assertEquals("October 15, 14:30 – 15:45", result)
    }
}