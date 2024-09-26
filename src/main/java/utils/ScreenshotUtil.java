package utils;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
public class ScreenshotUtil {
	public static String captureScreenshot(WebDriver driver) {
	    TakesScreenshot ts = (TakesScreenshot) driver;
	    File source = ts.getScreenshotAs(OutputType.FILE);
	    String timestamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
	    String screenshotName = "screenshot-" + timestamp + ".png"; // Generate screenshot name with date
	    String destination = "D:/Project/Project/test-output/Screenshots/" + screenshotName; // Absolute path
	    File finalDestination = new File(destination);
	   
	    try {
	        Files.copy(source.toPath(), finalDestination.toPath());
	        System.out.println("Screenshot saved at: " + finalDestination.getAbsolutePath()); // Log the path
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	   
	    return finalDestination.getAbsolutePath(); // Return absolute path to the screenshot
	}
}
