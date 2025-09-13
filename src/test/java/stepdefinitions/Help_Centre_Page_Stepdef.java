
package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.Help_Centre_Page;
import utils.Base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Help_Centre_Page_Stepdef {

    WebDriver driver;
    Help_Centre_Page helpCentrePage;

    public Help_Centre_Page_Stepdef() {
        this.driver = Hooks.driver; // Assuming you are using Hooks to initialize driver
        helpCentrePage = new Help_Centre_Page(driver);
    }

    @When("User clicks on Help Center button")
    public void user_clicks_on_help_center_button() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        // click parent button of the image
        WebElement helpCenterBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='app']/div/div/div[1]/button")
        ));
        Assert.assertTrue(helpCenterBtn.isDisplayed(), "❌ Help Center button not visible after click!");
        System.out.println("✅ Help Center button clicked successfully");
        helpCenterBtn.click();
        Base.sleep();
    }


    @And("User selects {string} service")
    public void user_selects_service(String serviceName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Locate service option by absolute XPath
        WebElement serviceOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='app']/div/div/div[1]/div/div[1]/div[3]/div[2]/div/div[4]")
        ));
        Assert.assertTrue(serviceOption.isDisplayed(), "❌ Service option not visible!");
        System.out.println("✅ Service option selected successfully");
        serviceOption.click();
        Base.sleep();
    }

    @And("User selects complaint issue {string}")
    public void user_selects_complaint_issue(String issueName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Locate issue option by absolute XPath
        WebElement issueOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='app']/div/div/div[1]/div/div[1]/div[2]/div[2]/div/div[4]/div[1]")
        ));
        Assert.assertTrue(issueOption.isDisplayed(), "❌ Complaint issue option not visible!");
        System.out.println("✅ Complaint issue selected successfully");
        issueOption.click();
        Base.sleep();
    }

    @Then("User closes the Help Center panel")
    public void user_closes_the_help_center_panel() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Locate the close button (img inside button)
        WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='app']/div/div/div[2]/button/img")
        ));
        
        closeBtn.click();
        Base.sleep();
    }

}
