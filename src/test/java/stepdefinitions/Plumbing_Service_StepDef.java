package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.*;
import pages.LoginPage;
import pages.Plumbing_Service_Page;
import utils.Base;

public class Plumbing_Service_StepDef {

    WebDriver driver = Hooks.driver;
    LoginPage loginPage;
    Plumbing_Service_Page plumbingPage;

  
   

    // ---------------- NAVIGATION ----------------
    @When("the user navigates to the plumbing services {string}")
    public void the_user_navigates_to_the_plumbing_services(String target) {
        plumbingPage = new Plumbing_Service_Page(driver);

        // Menu button
        WebElement menuBtn = new WebDriverWait(driver, Duration.ofSeconds(15))
            .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='main-menu']/div[1]")));
        Assert.assertTrue(menuBtn.isDisplayed(), "❌ Menu button not visible!");
        plumbingPage.clickMenuButton();
        System.out.println("✅ Menu button clicked and visible");

        // Painting & Cleaning
        WebElement pcBtn = new WebDriverWait(driver, Duration.ofSeconds(15))
            .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='main-menu']/div[2]/a[3]")));
        Assert.assertTrue(pcBtn.isDisplayed(), "❌ Painting & Cleaning button not visible!");
        plumbingPage.clickPaintingCleaning();
        System.out.println("✅ Painting & Cleaning clicked and visible");

        // City selection
        plumbingPage.selectCity(); // optional, assertion handled in selectCity method

        // EPC button
        WebElement epcBtn = new WebDriverWait(driver, Duration.ofSeconds(15))
            .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='hs_plumbing']/div[1]/div[1]/div")));
        Assert.assertTrue(epcBtn.isDisplayed(), "❌ EPC button not visible!");
        plumbingPage.clickEPCButton();
        System.out.println("✅ EPC button clicked and visible");

        // Plumbing button
        WebElement plumbingBtn = new WebDriverWait(driver, Duration.ofSeconds(15))
            .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='app']/div/div/main/div/div/div[2]/div/div/div/div[1]/div[2]")));
        Assert.assertTrue(plumbingBtn.isDisplayed(), "❌ Plumbing button not visible!");
        plumbingPage.clickPlumbingButton();
        System.out.println("✅ Plumbing button clicked and visible");

        if (target.equalsIgnoreCase("section")) {
            System.out.println("✅ Navigated to plumbing services section.");
        } else if (target.equalsIgnoreCase("booking page")) {
            // Plumbing category
            WebElement categoryBtn = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='hs_plumbing']/div[1]/div[1]/div")));
            Assert.assertTrue(categoryBtn.isDisplayed(), "❌ Plumbing category not visible!");
            plumbingPage.clickPlumbingCategory();
            System.out.println("✅ Navigated to plumbing services booking page with category clickable.");
        } else {
            throw new IllegalArgumentException("❌ Unknown navigation target: " + target);
        }
    }

    @Then("the user clicks show more button")
    public void the_user_clicks_show_more_button() {
        WebElement showMoreBtn = new WebDriverWait(driver, Duration.ofSeconds(15))
            .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"PLUMBING_OTHER_SOMETHING_ELSE\"]/div[3]/div/div")));
        Assert.assertTrue(showMoreBtn.isDisplayed(), "❌ Show More button not visible!");
        plumbingPage.clickShowMore();
        System.out.println("✅ Show More button clicked and visible");
    }

    // ---------------- SERVICE FLOW ----------------
   
}
