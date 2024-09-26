package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dropdown {

    public WebDriver driver;
    public WebDriverWait wait;

    public Dropdown(WebDriver driver, Duration timeout) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, timeout);
    }

    /**
     * Generic method to click on a dropdown and then a submenu item.
     *
     * @param dropdown - WebElement for the dropdown element.
     * @param submenu - WebElement for the submenu item.
     */
    public void clickDropdownAndSubmenu(WebElement dropdown, WebElement submenu) {
        // Wait until the dropdown is clickable
        wait.until(ExpectedConditions.elementToBeClickable(dropdown));

        // Click on the dropdown to make the submenu visible
        dropdown.click();

        // Wait until the submenu item is visible
        wait.until(ExpectedConditions.visibilityOf(submenu));

        // Use Actions class to move to submenu and click
        Actions actions = new Actions(driver);
        actions.moveToElement(submenu).click().perform();
    }
}