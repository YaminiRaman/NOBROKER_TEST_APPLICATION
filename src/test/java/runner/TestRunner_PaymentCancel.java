package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features/paymentcancel.feature",       // path to your feature files
    glue = {"stepdefinitions"},                     // package containing step defs
    plugin = {
        "pretty",
        "html:target/cucumber-reports/cancel-payment.html",
        "json:target/cucumber-reports/cancel-payment.json",
        "rerun:target/rerun.txt"
    },
                         // optional: run only tagged scenarios
    monochrome = true
)
public class TestRunner_PaymentCancel extends AbstractTestNGCucumberTests {
}
