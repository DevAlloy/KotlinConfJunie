# UI Testing for KotlinConf App

This directory contains UI tests for the KotlinConf Android app using Jetpack Compose testing.

## Test Structure

The UI tests are organized as follows:

- `BaseComposeTest.kt`: Base class for all Compose UI tests, providing common functionality.
- `MainActivityTest.kt`: Tests for the main activity and navigation flow.
- `SessionScreenTest.kt`: Tests for the session detail screen.
- `SpeakerDetailScreenTest.kt`: Tests for the speaker detail screen.
- `SettingsScreenTest.kt`: Tests for the settings screen.

## Running the Tests

### Android Tests

To run all Android UI tests:

```bash
./gradlew androidApp:connectedAndroidTest
```

To run a specific test class:

```bash
./gradlew androidApp:connectedAndroidTest -Pandroid.testInstrumentationRunnerArguments.class=org.jetbrains.kotlinconf.android.MainActivityTest
```

### iOS Tests

The iOS UI tests are located in `iosApp/KotlinConfUITests/`. To run these tests:

1. Open the Xcode project: `iosApp/KotlinConf.xcodeproj`
2. Add the UI test target to the project if it doesn't exist:
   - File > New > Target > iOS > Test > UI Testing Bundle
   - Add the `KotlinConfUITests.swift` file to this target
3. Run the tests using Xcode's Test Navigator (⌘U)

## Test Coverage

The UI tests cover the following key user flows:

1. **Onboarding Flow**
   - Privacy notice acceptance
   - Notification permissions

2. **Main Navigation**
   - Tab navigation (Schedule, Map, Info)
   - Back navigation

3. **Session Details**
   - Viewing session information
   - Speaker navigation
   - Room/map navigation

4. **Speaker Details**
   - Viewing speaker information
   - Session navigation
   - Social media links

5. **Settings**
   - Theme selection
   - Notification toggles

## Best Practices

- Tests are designed to be independent and can run in any order
- Each test focuses on a specific user flow or functionality
- Tests use semantic selectors (text, content description) rather than implementation details
- Flakiness is minimized by using appropriate waits and assertions
- No platform-specific dependencies are introduced into shared KMP modules