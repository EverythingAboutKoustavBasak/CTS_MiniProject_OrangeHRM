package TestSelenium;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import utilityFiles.ExcelUtils;
import utilityFiles.ScreenshotScroll;

public class AdminPanel extends Implementation{
	   // Navigate to Admin 
    public void adminPanel() {
	 driver.findElement(By.xpath("//ul[@class='oxd-main-menu']/li[1]")).click(); // Click Admin in the sidebar
	 
	 driver.findElement(By.xpath("//nav[@aria-label='Topbar Menu']/ul/li[2]")).click();  // Click Jobs in the top Navbar //nav[@aria-label='Topbar Menu']/ul/li[2]            //nav[@aria-label='Topbar Menu']//li[2]
	
	 //Checking if the Job Titles is present or not
	 
	 if(driver.findElement(By.xpath("//ul[@class='oxd-dropdown-menu' ]//li[1]//a")).getText().contains("Job Titles")) {
		 System.out.println("'Job Titles' is present");
		 driver.findElement(By.xpath("//ul[@class='oxd-dropdown-menu' ]//li[1]//a")).click();
	 }
	 else {
		 System.out.println("'Job Titles' is not present");
	 }
	 
    }    
    
    //Get the job titles
    
    public void getJobTitles() throws IOException, InterruptedException {
    	
    //div[contains(@class, 'oxd-table-cell')][2]/div
    List<WebElement> jobTitles = driver.findElements(By.xpath("//div[contains(@class, 'oxd-table-cell')][2]/div")); // Get the Job titles in a list of Web elements
    String file=System.getProperty("user.dir")+"//Test_Data//testexcel.xlsx";
    
    // Writing the job titles to testexcel.xlsx Sheet3 
    ScreenshotScroll.scroll();
    
    for(int w = 0; w < jobTitles.size();w++) {
    		String text = jobTitles.get(w).getText();
    		System.out.println(text);
    		ExcelUtils.setCellData(file, "Sheet3",1,w+1,text);
    	}
    	
    }
    
    
    //6 adding jobs to the list
    public void addJob() throws IOException, InterruptedException {
    	JavascriptExecutor js = (JavascriptExecutor)driver;
    	WebElement add = driver.findElement(By.xpath("//button[normalize-space()='Add']"));  // Click on the Add Button 
    	js.executeScript("arguments[0].click()", add);
    	String file=System.getProperty("user.dir")+"//Test_Data//testexcel.xlsx";
    	String jobTitle = ExcelUtils.getCellData(file,"Sheet3", 0, 1); 				// Take the Job Title from Excel Sheet3
    	
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//div[@class = 'oxd-form-row']//input[@class ='oxd-input oxd-input--active']")).sendKeys(jobTitle); // Input the data in Job Title
    	driver.findElement(By.xpath("//button[@type='submit']")).click(); // CLick Save Button
    	}
    }
