package stepdefinitions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import utils.Base;

public class Hooks extends Base {
    
    static ExtentSparkReporter spark;
    static ExtentReports extReports;
    public static ExtentTest extTest;    // public so other classes can log to it if needed
    
    @BeforeAll
    public static void beforeAll(){
        // Make sure the folder 'report' exists or create it before running
        spark = new ExtentSparkReporter("report/ExtentReport.html");
        extReports = new ExtentReports();
        extReports.attachReporter(spark);
    }
    
    @AfterAll
    public static void afterAll(){
        extReports.flush();
    }
    
    @Before
    public void setup(Scenario scenario){
        lanchBrowser();                       // starts WebDriver and sets driver in Base
        extTest = extReports.createTest(scenario.getName());
        extTest.info("Scenario started: " + scenario.getName());
    }
    
    @After
    public void tearDown(Scenario scenario){
        // Log scenario status to Extent report
        if (scenario.isFailed()) {
            extTest.fail("Scenario FAILED: " + scenario.getName());
        } else {
            extTest.pass("Scenario PASSED: " + scenario.getName());
        }

        // optional: you can add screenshot capture here and attach to extTest if needed
        
        // small pause if needed (keeps your original call)
        try {
            Base.sleep();
        } catch (Exception ignored) {}
        
        // Quit driver safely
        try {
            if (driver != null) {
                driver.quit();
            }
        } catch (Exception e) {
            // avoid throwing from @After, just log to report
            extTest.warning("Error while quitting driver: " + e.getMessage());
        }
    }
}