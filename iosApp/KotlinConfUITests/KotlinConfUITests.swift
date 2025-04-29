import XCTest

class KotlinConfUITests: XCTestCase {
    
    let app = XCUIApplication()
    
    override func setUpWithError() throws {
        // Put setup code here. This method is called before the invocation of each test method in the class.
        
        // In UI tests it is usually best to stop immediately when a failure occurs.
        continueAfterFailure = false
        
        // Launch the app
        app.launch()
    }
    
    override func tearDownWithError() throws {
        // Put teardown code here. This method is called after the invocation of each test method in the class.
    }
    
    /**
     * Test that the main screen is displayed when the app is launched.
     */
    func testMainScreenIsDisplayed() throws {
        // Wait for the app to load
        sleep(1)
        
        // Verify that the main screen is displayed
        // Note: This assumes there's a "Schedule" tab in the main screen
        XCTAssertTrue(app.buttons["Schedule"].exists)
    }
    
    /**
     * Test navigation between main tabs.
     */
    func testMainScreenTabNavigation() throws {
        // Wait for the app to load
        sleep(1)
        
        // Navigate to the Map tab
        app.buttons["Map"].tap()
        // Verify that the Map screen is displayed
        XCTAssertTrue(app.otherElements["MapView"].exists)
        
        // Navigate to the Info tab
        app.buttons["Info"].tap()
        // Verify that the Info screen is displayed
        XCTAssertTrue(app.staticTexts["About"].exists)
    }
    
    /**
     * Test the session detail screen.
     */
    func testSessionDetailScreen() throws {
        // Wait for the app to load
        sleep(1)
        
        // Navigate to the Schedule tab
        app.buttons["Schedule"].tap()
        
        // Tap on the first session
        app.cells.element(boundBy: 0).tap()
        
        // Verify that the session detail screen is displayed
        XCTAssertTrue(app.navigationBars.buttons["Back"].exists)
        
        // Navigate back
        app.navigationBars.buttons["Back"].tap()
    }
    
    /**
     * Test the speaker detail screen.
     */
    func testSpeakerDetailScreen() throws {
        // Wait for the app to load
        sleep(1)
        
        // Navigate to the Schedule tab
        app.buttons["Schedule"].tap()
        
        // Tap on the first session
        app.cells.element(boundBy: 0).tap()
        
        // Tap on the speaker
        app.buttons["Speaker"].tap()
        
        // Verify that the speaker detail screen is displayed
        XCTAssertTrue(app.navigationBars.buttons["Back"].exists)
        
        // Navigate back
        app.navigationBars.buttons["Back"].tap()
        
        // Navigate back to the schedule
        app.navigationBars.buttons["Back"].tap()
    }
    
    /**
     * Test the settings screen.
     */
    func testSettingsScreen() throws {
        // Wait for the app to load
        sleep(1)
        
        // Navigate to the Info tab
        app.buttons["Info"].tap()
        
        // Tap on the Settings button
        app.buttons["Settings"].tap()
        
        // Verify that the settings screen is displayed
        XCTAssertTrue(app.staticTexts["Theme"].exists)
        XCTAssertTrue(app.staticTexts["Notifications"].exists)
        
        // Toggle a setting
        app.switches.element(boundBy: 0).tap()
        
        // Navigate back
        app.navigationBars.buttons["Back"].tap()
    }
}