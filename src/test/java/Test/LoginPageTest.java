package Test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import base.BaseTest;
import page.LoginPage;

public class LoginPageTest extends BaseTest {
	
   
     LoginPage loginPage;
     

    @BeforeClass
    public void setUp() {
        setup(); // Call setup to initialize the driver
        loginPage = new LoginPage(driver, prop); // Pass driver and properties
    }

    @Test(priority = 1, enabled = true)
    public void userLogin() {
        boolean loginSuccess = loginPage.userLogin();

        // Check if login was successful
        Assert.assertTrue(loginSuccess, "Login attempt failed, unable to retrieve error message.");

        // After successful login, retrieve the expected message
        String msg = driver.findElement(By.xpath("(//div[@class='widget-heading'])[1]")).getText();
        Assert.assertEquals(msg, "Mining With QC Store", "The Email OR Password Is Incorrect, Please Try Again");
    }
}
