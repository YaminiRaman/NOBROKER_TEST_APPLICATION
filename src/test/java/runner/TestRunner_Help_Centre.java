package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features/helpcentre.feature",
    glue = {"stepdefinitions"},
    plugin = {"pretty","html:target/cucumber-report.html"},
    monochrome = true
)
public class TestRunner_Help_Centre extends AbstractTestNGCucumberTests {
}