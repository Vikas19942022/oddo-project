package baseLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {
    
    public static WebDriver driver;
    public static Properties prop;

    // Load properties from config.properties
    public void loadProperties() {
        prop = new Properties();
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/ConfigFiles/config.properties");
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Initialize WebDriver based on properties
    public WebDriver initialization() {
        loadProperties();  // Load properties first

        // Get the browser name from config.properties
        String browserName = prop.getProperty("browserName");
        
        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }

        // Maximize window and open the URL from config.properties
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        return driver;
    }
    
    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
