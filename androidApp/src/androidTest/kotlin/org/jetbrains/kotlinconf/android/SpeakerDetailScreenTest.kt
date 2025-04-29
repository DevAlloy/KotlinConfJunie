package org.jetbrains.kotlinconf.android

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.jetbrains.kotlinconf.SessionId
import org.jetbrains.kotlinconf.SpeakerId
import org.jetbrains.kotlinconf.screens.SpeakerDetailScreen
import org.junit.Test

/**
 * UI tests for the SpeakerDetailScreen.
 */
class SpeakerDetailScreenTest : BaseComposeTest() {

    /**
     * Test that the speaker details are displayed correctly.
     */
    @Test
    fun speakerDetailScreen_displaysSpeakerDetails() {
        // Set up a mock speaker ID
        val speakerId = SpeakerId("speaker1")
        
        // Set the content to the SpeakerDetailScreen
        composeTestRule.setContent {
            SpeakerDetailScreen(
                speakerId = speakerId,
                onBack = {},
                onSession = {}
            )
        }

        // Verify that the speaker details are displayed
        composeTestRule.onNodeWithText("Speaker Profile", useUnmergedTree = true).assertIsDisplayed()
        
        // Note: In a real test, you would check for actual speaker data
        // This is a simplified example that assumes there's a "Speaker Profile" title
    }

    /**
     * Test that clicking on a session navigates to the session detail screen.
     */
    @Test
    fun speakerDetailScreen_clickOnSession_navigatesToSessionDetail() {
        // Set up a mock speaker ID
        val speakerId = SpeakerId("speaker1")
        
        // Track if navigation to session detail was triggered
        var navigatedToSession = false
        var sessionId: SessionId? = null
        
        // Set the content to the SpeakerDetailScreen
        composeTestRule.setContent {
            SpeakerDetailScreen(
                speakerId = speakerId,
                onBack = {},
                onSession = { 
                    navigatedToSession = true
                    sessionId = it
                }
            )
        }

        // Click on a session (assuming there's a node with "Session" text)
        composeTestRule.onNodeWithText("Session", useUnmergedTree = true).performClick()
        
        // Verify that navigation to session detail was triggered
        assert(navigatedToSession)
        assert(sessionId != null)
    }

    /**
     * Test that clicking on the back button navigates back.
     */
    @Test
    fun speakerDetailScreen_clickOnBack_navigatesBack() {
        // Set up a mock speaker ID
        val speakerId = SpeakerId("speaker1")
        
        // Track if back navigation was triggered
        var navigatedBack = false
        
        // Set the content to the SpeakerDetailScreen
        composeTestRule.setContent {
            SpeakerDetailScreen(
                speakerId = speakerId,
                onBack = { navigatedBack = true },
                onSession = {}
            )
        }

        // Click on the back button
        composeTestRule.onNodeWithContentDescription("Back", useUnmergedTree = true).performClick()
        
        // Verify that back navigation was triggered
        assert(navigatedBack)
    }

    /**
     * Test that the speaker's social media links are displayed and clickable.
     */
    @Test
    fun speakerDetailScreen_socialMediaLinks_areDisplayedAndClickable() {
        // Set up a mock speaker ID
        val speakerId = SpeakerId("speaker1")
        
        // Set the content to the SpeakerDetailScreen
        composeTestRule.setContent {
            SpeakerDetailScreen(
                speakerId = speakerId,
                onBack = {},
                onSession = {}
            )
        }

        // Verify that social media links are displayed (assuming there's a Twitter icon)
        composeTestRule.onNodeWithContentDescription("Twitter", useUnmergedTree = true).assertIsDisplayed()
        
        // Click on the Twitter icon
        composeTestRule.onNodeWithContentDescription("Twitter", useUnmergedTree = true).performClick()
        
        // Note: In a real test, you would verify that the Twitter link is opened
        // This would require a more complex test setup with URL handling verification
    }
}