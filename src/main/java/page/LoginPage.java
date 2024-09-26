package page;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public WebDriver driver;
    public Properties prop;

    public LoginPage(WebDriver driver, Properties prop) {
        this.driver = driver;
        this.prop = prop; // Assign properties passed from BaseClass
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//nav[@class='nav-menu d-none d-lg-block']/ul/li)[6]/a")
    private WebElement loginButton;

    @FindBy(id = "exampleEmail")
    private WebElement username;

    @FindBy(id = "examplePassword")
    private WebElement password;

    @FindBy(xpath = "//button[@class='btn btn-lg btn-primary font-size-xlg w-50 login-btn']")
    private WebElement login;

    @FindBy(id = "exampleCheck")
    private WebElement keepmeLogin;

    @FindBy(id = "exampleForcefully")
    private WebElement forcefullyLogin;

    public boolean userLogin() {
        try {
            Thread.sleep(5000);
            loginButton.click();
            Thread.sleep(5000);

            username.clear();
            username.sendKeys(prop.getProperty("Username")); // Use Username from properties

            password.clear();
            password.sendKeys(prop.getProperty("Password")); // Use Password from properties

            keepmeLogin.click();
            forcefullyLogin.click();

            login.click();
            Thread.sleep(5000);

            System.out.println("Login Start");

            // Check if login was successful
            return isLoginSuccessful();

        } catch (Exception e) {
            System.out.println("Issue in LoginPage.userLogin: " + e);
            return false; // Return false if there's an exception
        }
    }

    // Method to determine if login was successful
    private boolean isLoginSuccessful() {
        // Replace this with actual logic to verify login success
        // Example: Check for an element that only appears when logged in
        try {
            // Assuming there's an element containing the text 'Dashboards' that appears on successful login
            return driver.findElements(By.xpath("//div[contains(text(), 'Dashboards')]")).size() > 0; // Change as needed
        } catch (Exception e) {
            return false;
        }
    }
    // Optional methods for checking broken links
    // Uncomment and modify if needed
    /*
    public void checkBrokenLinks() {
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("No of Links here " + links.size());
        List<String> urlList = new ArrayList<>();
        for (WebElement e : links) {
            String url = e.getAttribute("href");
            if (url != null && !url.isEmpty()) {
                urlList.add(url);
            }
        }

        long stTime = System.currentTimeMillis();
        urlList.parallelStream().forEach(this::checkBrokenLink);
        long endTime = System.currentTimeMillis();
        System.out.println("Total time taken: " + (endTime - stTime));
    }

    public void checkBrokenLink(String linkUrl) {
        try {
            URL url = new URL(linkUrl);
            HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();
            httpUrlConnection.setConnectTimeout(5000);
            httpUrlConnection.connect();
            if (httpUrlConnection.getResponseCode() >= 400) {
                System.out.println(linkUrl + " ---> " + httpUrlConnection.getResponseMessage() + " is a broken link");
            } else {
                System.out.println(linkUrl + " ---> " + httpUrlConnection.getResponseMessage());
            }
        } catch (Exception e) {
            System.out.println(linkUrl + " ---> Error: " + e.getMessage());
        }
    }
    */
}
