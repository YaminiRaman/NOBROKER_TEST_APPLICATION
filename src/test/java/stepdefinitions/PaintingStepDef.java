package stepdefinitions;

import io.cucumber.java.en.*;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import pages.LoginPage;
import pages.PaintingPage;
import pages.VipMembershipPage;

public class PaintingStepDef {
    WebDriver driver;
    PaintingPage paintingPage;
    LoginPage loginPage;

    public PaintingStepDef() {
        this.driver = Hooks.driver; // Hooks maintains WebDriver instance
        this.paintingPage = new PaintingPage(driver);
    }

   

    @When("the user opens the main menu for painting")
    public void the_user_opens_the_main_menu_for_painting() {
        paintingPage.openMenu();
    }

    @When("the user selects Painting and Cleaning for painting")
    public void the_user_selects_painting_and_cleaning_for_painting() {
        paintingPage.selectPaintingCleaning();
        paintingPage.selectCity();
    }

    @When("the user selects Painting for painting")
    public void the_user_selects_painting_for_painting() {
        paintingPage.selectPainting();
        paintingPage.selectWaterproofing();
        Assert.assertTrue(driver.getCurrentUrl().contains("painting"),
                "Painting page not loaded correctly!");
    }

   

}
