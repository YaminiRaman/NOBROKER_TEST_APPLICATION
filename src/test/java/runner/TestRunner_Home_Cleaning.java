package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/homecleaning.feature",
        glue = {"stepdefinitions"},
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        monochrome = true
)
public class TestRunner_Home_Cleaning extends AbstractTestNGCucumberTests {
}
