package ReadData;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {

    public WebDriver driver;

    @Test(dataProvider = "loginData", dataProviderClass = ExcelUtils.class)
    public void ninjaLoginTest(String firstName, String lastName, String email, String telephone, 
                               String password, String confirmPassword, String expectedResult) {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");

        // Fill out the form
        driver.findElement(By.id("input-firstname")).sendKeys(firstName);
        driver.findElement(By.id("input-lastname")).sendKeys(lastName);
        driver.findElement(By.id("input-email")).sendKeys(email);
        driver.findElement(By.id("input-telephone")).sendKeys(telephone);
        driver.findElement(By.id("input-password")).sendKeys(password);
        driver.findElement(By.id("input-confirm")).sendKeys(password);
        driver.findElement(By.xpath("(//input[@name='newsletter'])[1]")).click();
        driver.findElement(By.xpath("//input[@name='agree']")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        // Capture the actual result
        String actualResult = "";
        try {
            actualResult = driver.findElement(By.xpath("//h1[text()='Your Account Has Been Created!']")).getText();
        } catch (Exception e) {
            actualResult = driver.findElement(By.cssSelector("div.alert-danger")).getText();
        }

        // Print the actual result to the console (for debugging purposes)
        System.out.println("Expected Result: " + expectedResult);
        System.out.println("Actual Result: " + actualResult);

        // Validate the result using an assertion
        Assert.assertTrue(actualResult.contains(expectedResult), 
                          "Test failed: Expected result '" + expectedResult + "', but got '" + actualResult + "'.");

        driver.quit();
    }
}
