package runner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/features/renovation.feature", // path to your feature file
        glue = {"stepdefinitions"}, // package where step defs are
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html",
                "json:target/cucumber.json"
        },
        monochrome = true
)
public class TestRunner_Renovation extends AbstractTestNGCucumberTests {
    // No additional code needed, TestNG will pick up scenarios automatically
}
