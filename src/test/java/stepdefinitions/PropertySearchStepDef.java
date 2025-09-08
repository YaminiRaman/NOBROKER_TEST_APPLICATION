package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;

import pages.PropertySearch;

public class PropertySearchStepDef {
    private WebDriver driver;
    private PropertySearch propertySearch;

    @Given("the user is on the NoBroker home page")
    public void user_on_home_page() {
        driver = Hooks.driver;   // directly use driver from Hooks
        propertySearch = new PropertySearch(driver);
        propertySearch.openHomePage();
    }

    @When("the user selects {string} from the city dropdown")
    public void user_selects_city(String city) {
        propertySearch.selectCity(city);
    }

    @When("the user enters {string} as the locality")
    public void user_enters_locality(String locality) {
        propertySearch.enterLocality(locality);
    }

    @When("the user clicks on the Search button")
    public void user_clicks_search() {
        propertySearch.clickSearch();
    }

    @Then("the property listing page should be displayed")
    public void listings_page_should_be_displayed() {
        boolean displayed = propertySearch.isListingPageDisplayed();
        Assert.assertTrue(displayed, "Listing page was not displayed");
    }
}