package org.jetbrains.kotlinconf.android

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.jetbrains.kotlinconf.SessionId
import org.jetbrains.kotlinconf.screens.SessionScreen
import org.junit.Test

/**
 * UI tests for the SessionScreen.
 */
class SessionScreenTest : BaseComposeTest() {

    /**
     * Test that the session details are displayed correctly.
     */
    @Test
    fun sessionScreen_displaysSessionDetails() {
        // Set up a mock session ID
        val sessionId = SessionId("session1")
        
        // Set the content to the SessionScreen
        composeTestRule.setContent {
            SessionScreen(
                sessionId = sessionId,
                openedForFeedback = false,
                onBack = {},
                onPrivacyNoticeNeeded = {},
                onSpeaker = {},
                onWatchVideo = {},
                onNavigateToMap = {}
            )
        }

        // Verify that the session details are displayed
        composeTestRule.onNodeWithText("Session Details", useUnmergedTree = true).assertIsDisplayed()
        
        // Note: In a real test, you would check for actual session data
        // This is a simplified example that assumes there's a "Session Details" title
    }

    /**
     * Test that clicking on a speaker navigates to the speaker detail screen.
     */
    @Test
    fun sessionScreen_clickOnSpeaker_navigatesToSpeakerDetail() {
        // Set up a mock session ID
        val sessionId = SessionId("session1")
        
        // Track if navigation to speaker detail was triggered
        var navigatedToSpeaker = false
        
        // Set the content to the SessionScreen
        composeTestRule.setContent {
            SessionScreen(
                sessionId = sessionId,
                openedForFeedback = false,
                onBack = {},
                onPrivacyNoticeNeeded = {},
                onSpeaker = { navigatedToSpeaker = true },
                onWatchVideo = {},
                onNavigateToMap = {}
            )
        }

        // Click on the speaker (assuming there's a node with "Speaker" text or content description)
        composeTestRule.onNodeWithText("Speaker", useUnmergedTree = true).performClick()
        
        // Verify that navigation to speaker detail was triggered
        assert(navigatedToSpeaker)
    }

    /**
     * Test that clicking on the room name navigates to the map screen.
     */
    @Test
    fun sessionScreen_clickOnRoom_navigatesToMap() {
        // Set up a mock session ID
        val sessionId = SessionId("session1")
        
        // Track if navigation to map was triggered
        var navigatedToMap = false
        
        // Set the content to the SessionScreen
        composeTestRule.setContent {
            SessionScreen(
                sessionId = sessionId,
                openedForFeedback = false,
                onBack = {},
                onPrivacyNoticeNeeded = {},
                onSpeaker = {},
                onWatchVideo = {},
                onNavigateToMap = { navigatedToMap = true }
            )
        }

        // Click on the room name (assuming there's a node with "Room" text or content description)
        composeTestRule.onNodeWithText("Room", useUnmergedTree = true).performClick()
        
        // Verify that navigation to map was triggered
        assert(navigatedToMap)
    }

    /**
     * Test that clicking on the back button navigates back.
     */
    @Test
    fun sessionScreen_clickOnBack_navigatesBack() {
        // Set up a mock session ID
        val sessionId = SessionId("session1")
        
        // Track if back navigation was triggered
        var navigatedBack = false
        
        // Set the content to the SessionScreen
        composeTestRule.setContent {
            SessionScreen(
                sessionId = sessionId,
                openedForFeedback = false,
                onBack = { navigatedBack = true },
                onPrivacyNoticeNeeded = {},
                onSpeaker = {},
                onWatchVideo = {},
                onNavigateToMap = {}
            )
        }

        // Click on the back button
        composeTestRule.onNodeWithContentDescription("Back", useUnmergedTree = true).performClick()
        
        // Verify that back navigation was triggered
        assert(navigatedBack)
    }
}