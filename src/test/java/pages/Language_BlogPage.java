package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Language_BlogPage {

    WebDriver driver;
    WebDriverWait wait;

    public Language_BlogPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    private By menuButton = By.xpath("//*[@id='main-menu']/div[1]");
    private By blogsButton = By.xpath("//*[@id='main-menu']/div[2]/a[13]");
    private By listButton = By.xpath("//*[@id='hamburger']");
    private By languageDropdown = By.xpath("//*[@id=\"dropdownContent\"]/div[2]/div[11]/div[1]/div");
    private By hindiOption = By.xpath("//*[@id=\"dropdownContent\"]/div[2]/div[11]/div[2]/a[1]");

    // Methods corresponding to feature steps

    public void clickMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(menuButton)).click();
    }

    public void clickBlogs() {
        wait.until(ExpectedConditions.elementToBeClickable(blogsButton)).click();
    }

    public void clickHamburger() {
        wait.until(ExpectedConditions.elementToBeClickable(listButton)).click();
    }

    public void selectLanguageDropdown() {
        wait.until(ExpectedConditions.elementToBeClickable(languageDropdown)).click();
    }

    public void selectHindiLanguage() {
        wait.until(ExpectedConditions.elementToBeClickable(hindiOption)).click();
    }

    public boolean isHindiSelected() {
        // Example: check if the Hindi option is displayed as selected
        WebElement hindiCheck = wait.until(ExpectedConditions.visibilityOfElementLocated(hindiOption));
        return hindiCheck.isDisplayed();
    }
}