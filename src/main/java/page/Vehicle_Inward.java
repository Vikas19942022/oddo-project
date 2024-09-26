
package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.DropdownHandler;
import utils.ElementUtil;
import utils.JavaScriptUtil;
import utils.SeleniumUtils;

public class Vehicle_Inward {
	public WebDriver driver;
	// public WebDriverWait wait;
	ElementUtil eleUtil;
	JavaScriptUtil jsUtil;
	DropdownHandler dUtil;
	SeleniumUtils sUtil;

	public Vehicle_Inward(WebDriver driver) {
		this.driver = driver;
		// this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		PageFactory.initElements(driver, this);
		eleUtil = new ElementUtil(driver);
		jsUtil = new JavaScriptUtil(driver);
		dUtil = new DropdownHandler(driver);
		sUtil = new SeleniumUtils(driver);

	}

	@FindBy(xpath = "//*[text()='Transport']")
	private WebElement transPort;

	@FindBy(xpath = "(//a[text()='Transactions'])[6]")
	private WebElement transction;

	@FindBy(xpath = "//a[contains(text(),'Vehicle Inward')]")
	private WebElement vehiclInward;
	@FindBy(xpath = "//a[contains(@class, 'btn-shadow 7 btn btn-success')]")
	private WebElement createButton;
	@FindBy(xpath = "(//div[@class='filter-option-inner-inner' and text()='Mining With QC Store'])[1]")
	private WebElement Location;
	@FindBy(xpath = "//a[@role='option' and @class='dropdown-item' and @id='bs-select-1-1']/span[@class='text' and contains(text(), 'PADHAR')]")
	private WebElement Location_name;
	@FindBy(xpath = "//button[@data-id='stock_location_id']")
	private WebElement Stock_location;
	@FindBy(xpath = "//a[@id='bs-select-2-2']/span[@class='text' and text()='P-L-1']/..")
	private WebElement Stock_name;
	@FindBy(xpath = "//div[@class='filter-option-inner-inner' and text()='Select']")
	private WebElement select_customer;
	@FindBy(xpath = "//a[.//span[text()='Harish Mining']]")
	private WebElement customer_name;
	// @FindBy(xpath = "//select[contains(@class, 'vehicle_type')]")
	// private WebElement Select_vehicle;
	@FindBy(xpath = "//select[@id='vehicle_type']")
	private WebElement vehicle_type;
	@FindBy(xpath = "//input[@id='visitor_name']")
	private WebElement Transporter_Name;
	@FindBy(xpath = "//input[@id='vehicle_number']")
	private WebElement Vehicle_number;
	@FindBy(xpath = "//input[@id='model']")
	private WebElement Model;
	@FindBy(xpath = "//div[text()='Model 1']")
	private WebElement Model_ele;
	@FindBy(xpath = "//input[@placeholder='Make']")
	private WebElement Make;
	@FindBy(xpath = "//input[@id='driver_name']")
	private WebElement Driver_name;
	@FindBy(xpath = "//input[@id='driver_mobile_number']")
	private WebElement Driver_Number;
	@FindBy(xpath = "//input[@id='license_no']")
	private WebElement license_number;
	@FindBy(xpath = "//select[@id='vehicle_load']")
	private WebElement Select_item;
	// @FindBy(xpath = "//select[@id='vehicle_load']/option[@value='Empty']")
	// private WebElement Select_type;
	@FindBy(xpath = "//div[text()='Please Select']")
	private WebElement Select_group;
	@FindBy(xpath = "//span[text()='FIRST GROUP']")
	private WebElement Group_Name;
	@FindBy(xpath = "//input[@placeholder='Part Code Selection']")
	private WebElement Part_code;
	@FindBy(xpath = "//input[@placeholder='Vehicle’s Permitted Weight Capacity']")
	private WebElement Capacity_Weight;
	@FindBy(xpath = "//input[@name='weight_scale']")
	private WebElement weight_scale;
	@FindBy(xpath = "//*[@name='submit']")
	private WebElement Save;

	public void vehicle_inward() {
		try {
			System.out.println("start vehicle_inward");
			// wait.until(ExpectedConditions.elementToBeClickable(transPort)).click();
			eleUtil.waitForElementToBeClickable(30, transPort);
			transPort.click();
			// wait.until(ExpectedConditions.elementToBeClickable(transction)).click();
			eleUtil.waitForElementToBeClickable(30, transction);
			transction.click();

			// ((JavascriptExecutor)
			// driver).executeScript("arguments[0].scrollIntoView(true);", vehiclInward);
			jsUtil.scrollToWebElement(vehiclInward);

			// wait.until(ExpectedConditions.elementToBeClickable(vehiclInward)).click();
			eleUtil.waitForElementToBeClickable(30, vehiclInward);
			vehiclInward.click();
			eleUtil.waitForElementToBeClickable(30, createButton);
			createButton.click();
			Thread.sleep(5000);
			eleUtil.waitForElementToBeClickable(30,Location);
			Location.click();
			eleUtil.waitForElementToBeClickable(30, Location_name);
			Location_name.click();
			Thread.sleep(5000);
			// sUtil.clickDropdownAndSelectOption(Stock_location,Stock_name);
			eleUtil.waitForElementToBeClickable(30, Stock_location);
			Stock_location.click();
			eleUtil.waitForElementToBeClickable(30, Stock_name);
			Stock_name.click();
			Thread.sleep(5000);
			eleUtil.waitForElementToBeClickable(30, select_customer);
			select_customer.click();
			eleUtil.waitForElementToBeClickable(30, customer_name);
			customer_name.click();
			Thread.sleep(5000);

			dUtil.selectDropdownByVisibleText(vehicle_type, "Transporter");
			Thread.sleep(5000);
			Transporter_Name.clear();
			Transporter_Name.sendKeys("Ankit Srisvastav");
			Vehicle_number.clear();
			Vehicle_number.sendKeys("KA-03-PA-2000");
			Thread.sleep(5000);
			eleUtil.waitForElementToBeClickable(30, Model);
			Model.click();
			Thread.sleep(5000);
			eleUtil.waitForElementToBeClickable(30, Model_ele);
			Model_ele.click();
			Thread.sleep(5000);
			Make.clear();
			Make.sendKeys("MAHINDRA");
			Thread.sleep(5000);
			Driver_name.clear();
			Driver_name.sendKeys("Raj Yadav");
			Driver_Number.clear();
			Driver_Number.sendKeys("8010203045");
			license_number.clear();
			license_number.sendKeys("DL11220330044");
			Thread.sleep(5000);
			dUtil.selectDropdownByVisibleText(Select_item, "Empty");
			Thread.sleep(5000);
			sUtil.clickDropdownAndSelectOption(Select_group, Group_Name);
			Thread.sleep(5000);
			Part_code.sendKeys("TRA");
			Part_code.sendKeys(Keys.ARROW_DOWN);
			Part_code.click();
			Thread.sleep(5000);
			Capacity_Weight.clear();
			Capacity_Weight.sendKeys("20000");
			weight_scale.clear();
			weight_scale.sendKeys("5000");
			Thread.sleep(5000);
			jsUtil.scrollToWebElement(Save);

			// wait.until(ExpectedConditions.elementToBeClickable(vehiclInward)).click();
			eleUtil.waitForElementToBeClickable(30, Save);
			Save.click();
		} catch (Exception e) {
			System.out.println("Issue in Vehicle_Inward.vehicle_inward: " + e.getMessage());
			e.printStackTrace();

		}

	}
}
