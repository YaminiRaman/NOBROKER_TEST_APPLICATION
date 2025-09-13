package stepdefinitions;

import io.cucumber.java.en.*;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        // Assert Menu button is visible and clickable
        WebElement menuBtn = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"main-menu\"]/div[1]")));
        Assert.assertTrue(menuBtn.isDisplayed(), "❌ Menu button not visible!");
        paintingPage.openMenu();
        System.out.println("✅ Menu button clicked and visible");
    }

    @When("the user selects Painting and Cleaning for painting")
    public void the_user_selects_painting_and_cleaning_for_painting() {
        // Assert Painting & Cleaning option is visible and clickable
        WebElement paintingCleaning = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"main-menu\"]/div[2]/a[3]")));
        Assert.assertTrue(paintingCleaning.isDisplayed(), "❌ Painting & Cleaning option not visible!");
        paintingPage.selectPaintingCleaning();
        System.out.println("✅ Painting & Cleaning clicked and visible");

        // Assert City selection modal (Chennai) is visible if present
        try {
            WebElement chennai = new WebDriverWait(driver, Duration.ofSeconds(15))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"modalContent\"]/div[2]/div/div[3]/img")));
            Assert.assertTrue(chennai.isDisplayed(), "❌ Chennai city selection not visible!");
            paintingPage.selectCity();
            System.out.println("✅ Chennai city selected and visible");
        } catch (Exception e) {
            System.out.println("⚠ City selection modal not displayed, skipping assert...");
        }
    }

    @When("the user selects Painting for painting")
    public void the_user_selects_painting_for_painting() {
        paintingPage.selectPainting();
        paintingPage.selectWaterproofing();
        Assert.assertTrue(driver.getCurrentUrl().contains("painting"),
                "Painting page not loaded correctly!");
    }
    @When("the user clicks on See All in recent projects")
    public void the_user_clicks_on_see_all_in_recent_projects() {
        paintingPage.clickSeeAllProjects();
    }

   

}
