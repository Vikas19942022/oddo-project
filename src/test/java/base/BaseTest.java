package base;

import org.openqa.selenium.WebDriver;

import Litener.TestListener;
import baseLibrary.BaseClass;

public class BaseTest extends BaseClass {
    
    public static WebDriver driver; // Make WebDriver a static instance
    public TestListener myListener; // Declare an instance of TestListener
    
    public BaseTest() {
        super(); // Call the parent constructor if needed for setup
        myListener = new TestListener(); // Initialize the TestListener instance
    }
    
    public void setup() {
        // Initialize the WebDriver
        driver = initialization();
        myListener.setDriver(driver); // Set the driver in TestListener
    }
}
