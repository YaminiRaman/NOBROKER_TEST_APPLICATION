package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features/salesagreement.feature",          // path to your .feature files
        glue = {"stepdefinitions"},                       // package for step defs + hooks
        plugin = {
                "pretty", 
                "html:target/cucumber-reports.html", 
                "json:target/cucumber.json",
                "rerun:target/rerun.txt"
        },
        monochrome = true
)
public class TestRunner_SalesAgreement extends AbstractTestNGCucumberTests {

  
}

