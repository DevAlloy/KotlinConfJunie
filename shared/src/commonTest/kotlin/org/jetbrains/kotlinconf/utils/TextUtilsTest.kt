package org.jetbrains.kotlinconf.utils

import kotlin.test.Test
import kotlin.test.assertTrue
import kotlin.test.assertFalse
import kotlin.test.assertEquals

class TextUtilsTest {
    
    @Test
    fun testContainsDiacritics_withDiacritics() {
        // Arrange
        val textWithDiacritics = "résumé"
        
        // Act
        val result = textWithDiacritics.containsDiacritics()
        
        // Assert
        assertTrue(result)
    }
    
    @Test
    fun testContainsDiacritics_withoutDiacritics() {
        // Arrange
        val textWithoutDiacritics = "resume"
        
        // Act
        val result = textWithoutDiacritics.containsDiacritics()
        
        // Assert
        assertFalse(result)
    }
    
    @Test
    fun testContainsDiacritics_emptyString() {
        // Arrange
        val emptyString = ""
        
        // Act
        val result = emptyString.containsDiacritics()
        
        // Assert
        assertFalse(result)
    }
    
    @Test
    fun testRemoveDiacritics_withDiacritics() {
        // Arrange
        val textWithDiacritics = "résumé"
        
        // Act
        val result = textWithDiacritics.removeDiacritics()
        
        // Assert
        assertEquals("resume", result)
    }
    
    @Test
    fun testRemoveDiacritics_withoutDiacritics() {
        // Arrange
        val textWithoutDiacritics = "resume"
        
        // Act
        val result = textWithoutDiacritics.removeDiacritics()
        
        // Assert
        assertEquals("resume", result)
    }
    
    @Test
    fun testRemoveDiacritics_emptyString() {
        // Arrange
        val emptyString = ""
        
        // Act
        val result = emptyString.removeDiacritics()
        
        // Assert
        assertEquals("", result)
    }
    
    @Test
    fun testRemoveDiacritics_complexExample() {
        // Arrange
        val complexText = "Příliš žluťoučký kůň úpěl ďábelské ódy"
        
        // Act
        val result = complexText.removeDiacritics()
        
        // Assert
        assertEquals("Prilis zlutoucky kun upel dabelske ody", result)
    }
}