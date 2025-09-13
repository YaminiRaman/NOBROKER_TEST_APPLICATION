package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.RenovationPage;
 // assuming Hooks.driver and Hooks.extTest exist

public class Renovation_StepDef {

    WebDriver driver = Hooks.driver;
    LoginPage loginPage;
    RenovationPage renovationPage;

    

    @When("the user navigates through Home Renovation services")
    public void the_user_navigates_through_home_renovation_services() {
        renovationPage = new RenovationPage(driver);

        try {
            renovationPage.clickMenuButton();
            renovationPage.clickPaintingAndCleaning();
            renovationPage.selectCity(); // optional if city selection pops up
            renovationPage.clickInteriorAndRenovation();
            
            // Click Home Renovation and assert success
            renovationPage.clickHomeRenovation();
            System.out.println("✅ Home Renovation section clicked successfully.");
        } catch (Exception e) {
            Assert.fail("❌ Failed to navigate to Home Renovation section: " + e.getMessage());
        }
    }

    

  
}
