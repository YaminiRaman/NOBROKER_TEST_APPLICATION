package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features/showmoreplumbingservice.feature", // path to your new feature
    glue = {"stepdefinitions"},     // package where your step defs are stored
    plugin = {
        "pretty",
        "html:target/cucumber-reports/explore-plumbing-report.html",
        "json:target/cucumber-reports/explore-plumbing-report.json",
        "junit:target/cucumber-reports/explore-plumbing-report.xml"
    },
    monochrome = true,
    publish = true
)
public class TestRunner_Show_More_Plumbing extends AbstractTestNGCucumberTests {
}
