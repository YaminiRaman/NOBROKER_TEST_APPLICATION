package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
    features = "src/test/resources/features/landmark.feature",   // Path to feature files
    glue = {"stepdefinitions"},                 // Step definitions package
    plugin = {
        "pretty",
        "html:target/cucumber-reports/cucumber.html",
        "json:target/cucumber-reports/cucumber.json",
        "junit:target/cucumber-reports/cucumber.xml",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" // Extent report
    },
    monochrome = true,
    tags = "@home"   // Run only scenarios tagged with @home
)
public class TestRunner_Landmark_Page extends AbstractTestNGCucumberTests {

    // Enables parallel execution of scenario outlines if needed
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
