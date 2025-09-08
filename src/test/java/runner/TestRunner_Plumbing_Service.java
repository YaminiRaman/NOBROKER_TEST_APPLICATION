package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features/plumbingservice.feature",
    glue = {"stepdefinitions"},   // 👈 This must match the package of your StepDef classes
    plugin = {
        "pretty",
        "html:target/cucumber-reports.html",
        "json:target/cucumber.json"
    },
    monochrome = true
)
public class TestRunner_Plumbing_Service extends AbstractTestNGCucumberTests {
}