package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features/landmark.feature",
    glue = {"stepdefinitions"},
    plugin = {"pretty", "html:target/cucumber-report-login.html"},
    monochrome = true
)
public class TestRunner_Landmark extends AbstractTestNGCucumberTests {
    // no extra code needed
}