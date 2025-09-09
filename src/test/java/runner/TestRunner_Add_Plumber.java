package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/addplumbingservice.feature",   // path to your feature files
        glue = {"stepdefinitions"},                 // package where your step defs live
        plugin = {
                "pretty",                            // pretty console output
                "html:target/cucumber-reports/cucumber.html", // HTML report
                "json:target/cucumber-reports/cucumber.json", // JSON report
                "junit:target/cucumber-reports/cucumber.xml"  // JUnit report
        },
        monochrome = true    
        )// clean console output
                             // run only scenarios with this tag

public class TestRunner_Add_Plumber extends AbstractTestNGCucumberTests {
}