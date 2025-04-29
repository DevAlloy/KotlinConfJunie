package org.jetbrains.kotlinconf.android

import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule

/**
 * Base class for all Compose UI tests.
 * Provides common functionality and setup for testing Compose UI components.
 */
open class BaseComposeTest {
    /**
     * Creates a Compose testing rule that provides testing of Composables without a host activity.
     * This allows for testing Composables in isolation.
     */
    @get:Rule
    val composeTestRule = createComposeRule()
}