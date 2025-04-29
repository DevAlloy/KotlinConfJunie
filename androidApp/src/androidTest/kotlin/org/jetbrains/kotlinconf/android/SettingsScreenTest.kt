package org.jetbrains.kotlinconf.android

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsOn
import androidx.compose.ui.test.assertIsOff
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.jetbrains.kotlinconf.screens.SettingsScreen
import org.junit.Test

/**
 * UI tests for the SettingsScreen.
 */
class SettingsScreenTest : BaseComposeTest() {

    /**
     * Test that the settings screen displays all settings options.
     */
    @Test
    fun settingsScreen_displaysAllOptions() {
        // Set the content to the SettingsScreen
        composeTestRule.setContent {
            SettingsScreen(onBack = {})
        }

        // Verify that the settings title is displayed
        composeTestRule.onNodeWithText("Settings", useUnmergedTree = true).assertIsDisplayed()
        
        // Verify that theme settings are displayed
        composeTestRule.onNodeWithText("Theme", useUnmergedTree = true).assertIsDisplayed()
        
        // Verify that notification settings are displayed
        composeTestRule.onNodeWithText("Notifications", useUnmergedTree = true).assertIsDisplayed()
    }

    /**
     * Test that clicking on theme options changes the theme.
     */
    @Test
    fun settingsScreen_themeOptions_canBeChanged() {
        // Set the content to the SettingsScreen
        composeTestRule.setContent {
            SettingsScreen(onBack = {})
        }

        // Click on the Dark theme option
        composeTestRule.onNodeWithText("Dark", useUnmergedTree = true).performClick()
        
        // Verify that the Dark theme option is selected
        // Note: This assumes there's a radio button or similar component that can be checked
        // The actual implementation might differ
        composeTestRule.onNodeWithText("Dark", useUnmergedTree = true)
            .assertIsOn()
        
        // Click on the Light theme option
        composeTestRule.onNodeWithText("Light", useUnmergedTree = true).performClick()
        
        // Verify that the Light theme option is selected
        composeTestRule.onNodeWithText("Light", useUnmergedTree = true)
            .assertIsOn()
        
        // Verify that the Dark theme option is no longer selected
        composeTestRule.onNodeWithText("Dark", useUnmergedTree = true)
            .assertIsOff()
    }

    /**
     * Test that notification settings can be toggled.
     */
    @Test
    fun settingsScreen_notificationSettings_canBeToggled() {
        // Set the content to the SettingsScreen
        composeTestRule.setContent {
            SettingsScreen(onBack = {})
        }

        // Find the notification toggle (assuming there's a switch with a content description)
        val notificationToggle = composeTestRule.onNodeWithContentDescription(
            "Toggle notifications", 
            useUnmergedTree = true
        )
        
        // Get the initial state
        val initialState = try {
            notificationToggle.assertIsOn()
            true
        } catch (e: AssertionError) {
            false
        }
        
        // Toggle the notification setting
        notificationToggle.performClick()
        
        // Verify that the state has changed
        if (initialState) {
            notificationToggle.assertIsOff()
        } else {
            notificationToggle.assertIsOn()
        }
        
        // Toggle it back
        notificationToggle.performClick()
        
        // Verify that it's back to the initial state
        if (initialState) {
            notificationToggle.assertIsOn()
        } else {
            notificationToggle.assertIsOff()
        }
    }

    /**
     * Test that clicking on the back button navigates back.
     */
    @Test
    fun settingsScreen_clickOnBack_navigatesBack() {
        // Track if back navigation was triggered
        var navigatedBack = false
        
        // Set the content to the SettingsScreen
        composeTestRule.setContent {
            SettingsScreen(onBack = { navigatedBack = true })
        }

        // Click on the back button
        composeTestRule.onNodeWithContentDescription("Back", useUnmergedTree = true).performClick()
        
        // Verify that back navigation was triggered
        assert(navigatedBack)
    }
}