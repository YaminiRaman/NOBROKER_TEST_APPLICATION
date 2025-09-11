package stepdefinitions;

import org.openqa.selenium.WebDriver;
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
    }

    @When("the user selects Furnished Villa for home")
    public void the_user_selects_furnished_villa_for_home() {
        cleaningPage.clickFurnishedVilla();
    }

    @Then("the service page should appear for home")
    public void the_service_page_should_appear_for_home() {
        System.out.println("✅ Service page appeared successfully.");
    }
}
