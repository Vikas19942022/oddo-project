package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownHandler {

    WebDriver driver;

    public DropdownHandler(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Select a dropdown option by visible text.
     * 
     * @param locator - By locator of the dropdown element.
     * @param visibleText - The visible text of the option to select.
     */
    public void selectDropdownByVisibleText(WebElement dropdownElement, String visibleText) {
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(visibleText);
    }

    /**
     * Select a dropdown option by index.
     * 
     * @param locator - By locator of the dropdown element.
     * @param index - The index of the option to select.
     */
    public void selectDropdownByIndex(By locator, int index) {
        WebElement dropdownElement = driver.findElement(locator);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByIndex(index);
    }

    /**
     * Select a dropdown option by value.
     * 
     * @param locator - By locator of the dropdown element.
     * @param value - The value attribute of the option to select.
     */
    public void selectDropdownByValue(By locator, String value) {
        WebElement dropdownElement = driver.findElement(locator);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByValue(value);
    }
}
