# UI Testing for KotlinConf iOS App

This directory contains UI tests for the KotlinConf iOS app using XCTest UI Testing.

## Test Structure

The UI tests are organized in the `KotlinConfUITests.swift` file, which contains test methods for different screens and user flows:

- `testMainScreenIsDisplayed`: Tests that the main screen is displayed when the app is launched.
- `testMainScreenTabNavigation`: Tests navigation between the main tabs.
- `testSessionDetailScreen`: Tests the session detail screen.
- `testSpeakerDetailScreen`: Tests the speaker detail screen.
- `testSettingsScreen`: Tests the settings screen.

## Setting Up the UI Tests

To set up the UI tests in Xcode:

1. Open the Xcode project: `iosApp/KotlinConf.xcodeproj`
2. Add a UI test target to the project:
   - File > New > Target > iOS > Test > UI Testing Bundle
   - Name it "KotlinConfUITests"
   - Select the KotlinConf app as the target to be tested
3. Add the `KotlinConfUITests.swift` file to this target

## Running the Tests

To run the UI tests:

1. Open the Xcode project: `iosApp/KotlinConf.xcodeproj`
2. Select the UI test target
3. Run the tests using Xcode's Test Navigator (⌘U)

You can also run individual test methods by clicking the diamond icon next to each test method.

## Test Coverage

The UI tests cover the following key user flows:

1. **Main Navigation**
   - Tab navigation (Schedule, Map, Info)
   - Back navigation

2. **Session Details**
   - Viewing session information
   - Speaker navigation
   - Back navigation

3. **Speaker Details**
   - Viewing speaker information
   - Back navigation

4. **Settings**
   - Theme selection
   - Notification toggles
   - Back navigation

## Best Practices

- Tests are designed to be independent and can run in any order
- Each test focuses on a specific user flow or functionality
- Tests use accessibility identifiers and labels for reliable element identification
- Flakiness is minimized by using appropriate waits and assertions
- No platform-specific dependencies are introduced into shared KMP modules

## Troubleshooting

If tests are failing:

1. Make sure the app's UI elements have proper accessibility identifiers
2. Check that the test is using the correct identifiers to find elements
3. Add appropriate waits if elements are not immediately available
4. Run the app manually and verify the UI matches what the tests expect