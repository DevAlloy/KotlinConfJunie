# KotlinConf App UI Testing Strategy

This document outlines the UI testing strategy for the KotlinConf app on both Android and iOS platforms.

## Overview

The KotlinConf app is a Kotlin Multiplatform (KMP) application with platform-specific UI implementations:
- Android: Jetpack Compose
- iOS: SwiftUI

Our UI testing approach focuses on testing the platform-specific UI implementations while ensuring that all major user flows and screens are covered.

## Testing Frameworks

### Android
- **Framework**: Jetpack Compose Testing
- **Test Location**: `androidApp/src/androidTest/`
- **Key Components**:
  - `BaseComposeTest`: Base class for all Compose UI tests
  - Platform-specific test classes for each major screen

### iOS
- **Framework**: XCTest UI Testing
- **Test Location**: `iosApp/KotlinConfUITests/`
- **Key Components**:
  - `KotlinConfUITests`: Test class containing all UI tests

## Test Coverage

The UI tests cover the following key user flows and screens:

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

## Test Design Principles

1. **Independence**: Tests are designed to be independent and can run in any order.
2. **Focus**: Each test focuses on a specific user flow or functionality.
3. **Semantic Testing**: Tests use semantic selectors (text, content description, accessibility identifiers) rather than implementation details.
4. **Reliability**: Flakiness is minimized by using appropriate waits and assertions.
5. **Isolation**: No platform-specific dependencies are introduced into shared KMP modules.

## Running the Tests

### Android
```bash
./gradlew androidApp:connectedAndroidTest
```

### iOS
1. Open the Xcode project: `iosApp/KotlinConf.xcodeproj`
2. Run the tests using Xcode's Test Navigator (⌘U)

## CI Integration

The UI tests are designed to run in CI environments:

1. **Android**: Tests run on emulators or physical devices in CI.
2. **iOS**: Tests run on simulators in CI.

## Maintenance Strategy

1. **Regular Updates**: UI tests should be updated whenever the UI changes.
2. **Failure Analysis**: When tests fail, determine if it's due to:
   - Actual UI bugs
   - UI changes that require test updates
   - Test flakiness that needs to be addressed

3. **Coverage Expansion**: Regularly review and expand test coverage for new features.

## Best Practices

1. **Use Semantic Selectors**: Prefer text, content descriptions, and accessibility identifiers over implementation details.
2. **Minimize Waits**: Use explicit waits only when necessary.
3. **Test Real User Flows**: Design tests that mimic real user interactions.
4. **Keep Tests Simple**: Each test should verify a specific aspect of functionality.
5. **Document Test Assumptions**: Comment on any assumptions made in the tests.

## Resources

- [Android UI Testing Documentation](androidApp/src/androidTest/README.md)
- [iOS UI Testing Documentation](iosApp/KotlinConfUITests/README.md)