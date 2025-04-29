package org.jetbrains.kotlinconf.android

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

/**
 * UI tests for the MainActivity and main navigation flow.
 */
class MainActivityTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    /**
     * Test that the main screen is displayed when the app is launched.
     */
    @Test
    fun mainScreen_isDisplayed() {
        // Wait for the app to load
        Thread.sleep(1000)

        // Verify that the main screen is displayed
        // Note: This assumes there's a "Schedule" tab in the main screen
        composeTestRule.onNodeWithText("Schedule", useUnmergedTree = true).assertIsDisplayed()
    }

    /**
     * Test navigation between main tabs.
     */
    @Test
    fun mainScreen_tabNavigation() {
        // Wait for the app to load
        Thread.sleep(1000)

        // Navigate to the Map tab
        composeTestRule.onNodeWithText("Map", useUnmergedTree = true).performClick()
        // Verify that the Map screen is displayed
        composeTestRule.onNodeWithContentDescription("Map", useUnmergedTree = true).assertIsDisplayed()

        // Navigate to the Info tab
        composeTestRule.onNodeWithText("Info", useUnmergedTree = true).performClick()
        // Verify that the Info screen is displayed
        composeTestRule.onNodeWithText("About", useUnmergedTree = true).assertIsDisplayed()
    }

    /**
     * Test the onboarding flow if the user hasn't completed it yet.
     * Note: This test assumes the app is in a fresh state where onboarding hasn't been completed.
     */
    @Test
    fun onboardingFlow_isDisplayed_forNewUsers() {
        // This test would need to reset the app state to simulate a new user
        // For now, we'll just check if the privacy notice is displayed for new users
        
        // Wait for the app to load
        Thread.sleep(1000)

        // Check if we're in the onboarding flow by looking for the privacy notice
        // If onboarding is already completed, this test will fail
        composeTestRule.onNodeWithText("Privacy Notice", useUnmergedTree = true).assertIsDisplayed()
    }
}