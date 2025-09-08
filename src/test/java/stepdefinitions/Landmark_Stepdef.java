package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LandmarkPage;


public class Landmark_Stepdef {

    WebDriver driver = Hooks.driver;
    ExtentTest extTest = Hooks.extTest;

    LandmarkPage homePage;

    @Given("the user selects location {string}")
    public void the_user_selects_location(String location) {
        homePage = new LandmarkPage(driver, extTest);
        homePage.selectCity(location);
    }

    @When("enters landmark {string}")
    public void enters_landmark(String locality) {
        homePage.enterLocality(locality);
    }

    @When("leaves the landmark field blank")
    public void leaves_the_landmark_field_blank() {
        homePage.enterLocality("");
    }

    @When("clicks on search button")
    public void clicks_on_search_button() {
        homePage.clickSearchButton();
    }

    @Then("an error message should be displayed")
    public void an_error_message_should_be_displayed() {
        boolean errorShown = homePage.isLocalityErrorDisplayed();
        Assert.assertTrue(errorShown, "Expected error message, but none displayed.");
    }

    @Then("the user should be redirected to the Rent Page")
    public void the_user_should_be_redirected_to_the_rent_page() {
        boolean redirected = homePage.redirectedRentPage();
        Assert.assertTrue(redirected, "Expected Rent Page, but redirection failed.");
    }

    @When("the user returns to the home page")
    public void the_user_returns_to_the_home_page() {
        driver.navigate().to("https://www.nobroker.in/");
        driver.navigate().refresh();
    }

    @Then("the previous search {string} {string} should appear in search history")
    public void the_previous_search_should_appear_in_search_history(String location, String locality) {
        boolean historyShown = homePage.isSearchHistoryItemVisible(location, locality);
        Assert.assertTrue(historyShown, "Expected search history not found.");
    }
}
