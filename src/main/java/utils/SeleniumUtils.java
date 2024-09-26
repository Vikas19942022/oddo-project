package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SeleniumUtils {
    public WebDriver driver;
    public WebDriverWait wait;

    public SeleniumUtils(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public void clickDropdownAndSelectOption(WebElement dropdown, WebElement option) {
        // Wait for the dropdown to be clickable and click it
        WebElement dropdownElement = wait.until(ExpectedConditions.elementToBeClickable(dropdown));
        dropdownElement.click();

        // Wait for the option to be clickable, move to it, and click it
        WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(option));
        Actions actions = new Actions(driver);
        actions.moveToElement(optionElement).click().perform();
    }
}
