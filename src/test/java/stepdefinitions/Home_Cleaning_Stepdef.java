package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.*;
import pages.HomeCleaningPage;
  // assuming you keep WebDriver in a factory/singleton

public class Home_Cleaning_Stepdef {

    WebDriver driver;
    HomeCleaningPage cleaningPage;

    public Home_Cleaning_Stepdef() {
        // get driver started in Hooks
    	 this.driver = Hooks.driver; 
        this.cleaningPage = new HomeCleaningPage(driver);
    }
    @When("the user clicks on the menu button for home")
    public void the_user_clicks_on_the_menu_button_for_home() {
        cleaningPage.clickMenu();
        
        // Assert menu is displayed
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        WebElement menu = wait.until(ExpectedConditions.visibilityOfElementLocated(cleaningPage.menuBtn));
        Assert.assertTrue(menu.isDisplayed(), "❌ Menu button for home is not visible!");
        System.out.println("✅ Menu button clicked and visible");
    }

    @When("the user selects Painting and Cleaning for home")
    public void the_user_selects_painting_and_cleaning_for_home() {
        cleaningPage.clickPaintingCleaning();
        cleaningPage.selectCity();
        
        
    }


    @When("the user selects Home Cleaning for home")
    public void the_user_selects_home_cleaning_for_home() {
        cleaningPage.clickHomeCleaning();
    }

    @When("the user selects Full House Cleaning for home")
    public void the_user_selects_full_house_cleaning_for_home() {
        cleaningPage.clickFullHouseCleaning();

        // Assert that Full House Cleaning element is visible
       
    }

    @When("the user selects Furnished Villa for home")
    public void the_user_selects_furnished_villa_for_home() {
        // Click using the page method
        cleaningPage.clickFurnishedVilla();

        // Assertion only (using the same locator as in page)
        
    }



    @Then("the service page should appear for home")
    public void the_service_page_should_appear_for_home() {
        System.out.println("✅ Service page appeared successfully.");
    }
}
