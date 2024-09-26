package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseTest;
import page.TDSMasterPage;

public class TDSMasterPageTest extends BaseTest {
    TDSMasterPage tdsMasterPage;

    @BeforeTest
    public void setUpPage() {
        // Initialize the TDSMasterPage instance with the static driver
        tdsMasterPage = new TDSMasterPage(driver);
    }

    @Test(priority = 1, enabled = true)
    public void testFillAndSubmitTDSMasterForm() throws InterruptedException {
        // Test data for the TDS Master form
        String tdsCode = "TDS-123";
        String tdsName = "TDS Category A";
        String tdsType = "Type-1";
        String tdsTurnOver = "500000"; 
        String tdsPercentage = "10";

        // Fill and submit the form
        tdsMasterPage.fillAndSubmitTDSMasterForm(tdsCode, tdsName, tdsType, tdsTurnOver, tdsPercentage);

        // Example assertion: Verify that a success message is displayed
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert-custom alert alert-success alert-dismissible fade show']")).isDisplayed(), "Success message not displayed");
        String msg = driver.findElement(By.xpath("//div[@class='alert-custom alert alert-success alert-dismissible fade show']")).getText();
        System.out.println(msg);
    }
}
