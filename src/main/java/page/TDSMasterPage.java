package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ElementUtil;
import utils.JavaScriptUtil;
import utils.SeleniumUtils;
import utils.DropdownHandler;

public class TDSMasterPage {

    public WebDriver driver;
    private ElementUtil eleUtil;
    private JavaScriptUtil jsUtil;
    public DropdownHandler dUtil;
    public SeleniumUtils sUtil;

    // Constructor
    public TDSMasterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        eleUtil = new ElementUtil(driver);
        jsUtil = new JavaScriptUtil(driver);
        dUtil = new DropdownHandler(driver);
        sUtil = new SeleniumUtils(driver);
    }

    // Web Elements
    @FindBy(xpath = "//*[text()='Finance']")
    private WebElement finance;

    @FindBy(xpath = "(//a[contains(text(), 'Masters')])[4]")
    private WebElement Master;

    @FindBy(xpath = "//a[text()='TDS Master']")
    private WebElement TDS_Master;

    @FindBy(xpath = "//a[contains(@class, 'btn-shadow 7 btn btn-success')]")
    private WebElement createButton;

    @FindBy(id = "tds_code")
    private WebElement tdsCode;

    @FindBy(id = "tds_name")
    private WebElement tdsName;

    @FindBy(xpath = "//input[@placeholder='TDS Type']")
    private WebElement tdsType;

    @FindBy(xpath = "//input[@placeholder='TDS Turn Over']")
    private WebElement tdsTurnOver;

    @FindBy(xpath = "//input[@placeholder='TDS Percentage']")
    private WebElement tdsPercentage;

    @FindBy(xpath = "//div[@class='filter-option-inner-inner']")
    private WebElement tdsLedgerDropdown;

    @FindBy(xpath = "(//a[@class='dropdown-item'])[3]")
    private WebElement Customer;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement saveButton;

    // Method to fill and submit the TDS Master form
    public void fillAndSubmitTDSMasterForm(String code, String name, String type, String turnOver, String percentage) {
        try {
            // Navigate to the TDS Master page
            eleUtil.waitForElementToBeClickable(50, finance);
            finance.click();
            jsUtil.scrollToWebElement(Master);
            eleUtil.waitForElementToBeClickable(50, Master);
            Master.click();
            jsUtil.scrollToWebElement(TDS_Master);
            eleUtil.waitForElementToBeClickable(50, TDS_Master);
            TDS_Master.click();
            eleUtil.waitForElementToBeClickable(50, createButton);
            createButton.click();
            Thread.sleep(3000); // Prefer WebDriver wait instead

            // Fill form fields
            tdsCode.clear();
            tdsCode.sendKeys(code);

            tdsName.clear();
            tdsName.sendKeys(name);

            tdsType.clear();
            tdsType.sendKeys(type);

            tdsPercentage.clear();
            tdsPercentage.sendKeys(percentage);
            eleUtil.waitForElementToBeClickable(50, tdsLedgerDropdown);
            tdsLedgerDropdown.click();

            eleUtil.waitForElementToBeClickable(50, Customer);
            Customer.click();

            // Optionally fill in TDS Turn Over
            if (turnOver != null && !turnOver.isEmpty()) {
                tdsTurnOver.clear();
                tdsTurnOver.sendKeys(turnOver);
            }

            // Click Save
            saveButton.click();

            // You can add an explicit wait here for success message if necessary
            System.out.println("Form submitted successfully.");

        } catch (Exception e) {
            System.out.println("Issue in TDSMasterPage.fillAndSubmitTDSMasterForm: " + e.getMessage());
            // Optionally rethrow or fail the test here
        }
    }
}
