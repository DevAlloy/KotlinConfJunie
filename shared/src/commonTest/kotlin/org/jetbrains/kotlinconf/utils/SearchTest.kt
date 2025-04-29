package org.jetbrains.kotlinconf.utils

import kotlin.test.Test
import kotlin.test.assertEquals

class SearchTest {
    
    data class TestItem(val name: String, val description: String)
    
    @Test
    fun testPerformSearch_exactMatch() {
        // Arrange
        val items = listOf(
            TestItem("Kotlin", "A modern programming language"),
            TestItem("Java", "An object-oriented language"),
            TestItem("Swift", "Apple's programming language")
        )
        val searchText = "kotlin"
        
        // Act
        val results = items.performSearch(
            searchText = searchText,
            produceResult = { item, matches -> 
                Pair(item, matches.flatten().size) 
            },
            selectors = listOf({ it.name }, { it.description })
        )
        
        // Assert
        assertEquals(1, results.size)
        assertEquals("Kotlin", results[0].first.name)
        assertEquals(1, results[0].second) // One match in the name
    }
    
    @Test
    fun testPerformSearch_multipleMatches() {
        // Arrange
        val items = listOf(
            TestItem("Kotlin", "Kotlin is a modern programming language"),
            TestItem("Java", "An object-oriented language"),
            TestItem("Swift", "Apple's programming language")
        )
        val searchText = "kotlin"
        
        // Act
        val results = items.performSearch(
            searchText = searchText,
            produceResult = { item, matches -> 
                Pair(item, matches.flatten().size) 
            },
            selectors = listOf({ it.name }, { it.description })
        )
        
        // Assert
        assertEquals(1, results.size)
        assertEquals("Kotlin", results[0].first.name)
        assertEquals(2, results[0].second) // One match in name, one in description
    }
    
    @Test
    fun testPerformSearch_multipleItems() {
        // Arrange
        val items = listOf(
            TestItem("Kotlin", "A modern programming language"),
            TestItem("Java", "An object-oriented language"),
            TestItem("Programming", "The act of writing code")
        )
        val searchText = "program"
        
        // Act
        val results = items.performSearch(
            searchText = searchText,
            produceResult = { item, _ -> item },
            selectors = listOf({ it.name }, { it.description })
        )
        
        // Assert
        assertEquals(2, results.size)
        assertEquals(setOf("Kotlin", "Programming"), results.map { it.name }.toSet())
    }
    
    @Test
    fun testPerformSearch_withDiacritics() {
        // Arrange
        val items = listOf(
            TestItem("résumé", "A document"),
            TestItem("resume", "To continue"),
            TestItem("other", "Something else")
        )
        val searchText = "resume"
        
        // Act
        val results = items.performSearch(
            searchText = searchText,
            produceResult = { item, _ -> item },
            selectors = listOf({ it.name }, { it.description })
        )
        
        // Assert
        assertEquals(2, results.size)
        assertEquals(setOf("résumé", "resume"), results.map { it.name }.toSet())
    }
    
    @Test
    fun testPerformSearch_searchWithDiacritics() {
        // Arrange
        val items = listOf(
            TestItem("résumé", "A document"),
            TestItem("resume", "To continue"),
            TestItem("other", "Something else")
        )
        val searchText = "résumé"
        
        // Act
        val results = items.performSearch(
            searchText = searchText,
            produceResult = { item, _ -> item },
            selectors = listOf({ it.name }, { it.description })
        )
        
        // Assert
        assertEquals(1, results.size)
        assertEquals("résumé", results[0].name)
    }
    
    @Test
    fun testPerformSearch_noMatches() {
        // Arrange
        val items = listOf(
            TestItem("Kotlin", "A modern programming language"),
            TestItem("Java", "An object-oriented language"),
            TestItem("Swift", "Apple's programming language")
        )
        val searchText = "python"
        
        // Act
        val results = items.performSearch(
            searchText = searchText,
            produceResult = { item, _ -> item },
            selectors = listOf({ it.name }, { it.description })
        )
        
        // Assert
        assertEquals(0, results.size)
    }
    
    @Test
    fun testPerformSearch_emptyList() {
        // Arrange
        val items = emptyList<TestItem>()
        val searchText = "kotlin"
        
        // Act
        val results = items.performSearch(
            searchText = searchText,
            produceResult = { item, _ -> item },
            selectors = listOf({ it.name }, { it.description })
        )
        
        // Assert
        assertEquals(0, results.size)
    }
    
    @Test
    fun testPerformSearch_emptySearchText() {
        // Arrange
        val items = listOf(
            TestItem("Kotlin", "A modern programming language"),
            TestItem("Java", "An object-oriented language"),
            TestItem("Swift", "Apple's programming language")
        )
        val searchText = ""
        
        // Act
        val results = items.performSearch(
            searchText = searchText,
            produceResult = { item, _ -> item },
            selectors = listOf({ it.name }, { it.description })
        )
        
        // Assert
        assertEquals(3, results.size) // Empty regex matches everything
    }
}