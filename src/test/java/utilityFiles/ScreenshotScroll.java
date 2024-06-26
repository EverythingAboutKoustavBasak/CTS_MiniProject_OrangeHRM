package utilityFiles;

import java.io.File;
import java.io.IOException;
import DriverSetup.Driver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenshotScroll extends Driver{
	 public static void screenshot() throws IOException{
	    	TakesScreenshot ts = (TakesScreenshot)driver;
	    	File src = ts.getScreenshotAs(OutputType.FILE);
	    	File trg = new File("C:\\Users\\2323742\\OneDrive - Cognizant\\Desktop\\Mini_OrangeHRM\\OrangeHRM\\Screenshot\\ss1.png");
	    	FileUtils.copyFile(src,trg);
	    }
	    // code for scroll the page
	    public static void scroll() throws InterruptedException {
	    	JavascriptExecutor js = (JavascriptExecutor)driver;   	
	    	js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	    	Thread.sleep(2000);
	    	js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
	    }
}
