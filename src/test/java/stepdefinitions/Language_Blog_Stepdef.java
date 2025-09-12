package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import pages.Language_BlogPage;
import pages.LoginPage;


public class Language_Blog_Stepdef {


    Language_BlogPage menuPage = new Language_BlogPage(Hooks.driver);

   

    @When("the user clicks on the menu in blogs")
    public void the_user_clicks_on_the_menu_in_blogs() {
        menuPage.clickMenu();
    }

    @When("the user clicks on blogs for language")
    public void the_user_clicks_on_blogs_for_language() {
        menuPage.clickBlogs();
    }

    @When("the user clicks on the hamburger menu in blogs")
    public void the_user_clicks_on_the_hamburger_menu_in_blogs() {
        menuPage.clickHamburger();
    }

    @When("the user selects {string} language from the dropdown")
    public void the_user_selects_language_from_the_dropdown(String language) {
        menuPage.selectLanguageDropdown();
        if(language.equalsIgnoreCase("Hindi")) {
            menuPage.selectHindiLanguage();
        }
    }

    @Then("the language should be switched to {string}")
    public void the_language_should_be_switched_to(String language) {
        if(language.equalsIgnoreCase("Hindi")) {
            Assert.assertTrue(menuPage.isHindiSelected(), "Hindi language was not selected");
        }
    }
}