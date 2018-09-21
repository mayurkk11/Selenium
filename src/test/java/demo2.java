import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class demo2
{

 // Create global variable which will be used in all method
 ExtentReports extent;
 ExtentTest logger;
 WebDriver driver;
 ExtentHtmlReporter repporter;
    
 // This code will run before executing any testcase
 	@BeforeMethod
	public void setup()
	{
		ExtentHtmlReporter reporter=new ExtentHtmlReporter("./Report/learn_automation2.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}



//Actual Test which will start the application and verify the title
	@Test
	public void browsersetup() throws IOException
	{
		
	
        System.setProperty("webdriver.gecko.driver","D:\\Firfox Geko driver\\geckodriver.exe");
	    driver =  new FirefoxDriver();
	    driver.get("http://dev.eluminousdev.com/solnet_noc/login");
	    driver.manage().window().maximize();
	   // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 }

	@Test( priority=1)
	public void loginTest() throws IOException, InterruptedException
	{
	
		repporter = new ExtentHtmlReporter("./Report/demo.html");
		extent = new ExtentReports();
		extent.attachReporter(repporter);
		driver.get("http://dev.eluminousdev.com/solnet_noc/login");
		driver.findElement(By.name("email")).click();
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys("akshay@gmail.com");
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("123456");
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='SOLNET'])[1]/following::input[5]")).click();
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Toggle navigation'])[1]/following::span[4]")).click();
		System.out.println("title is "+driver.getTitle());

			if (driver.getTitle().contains("Dashboard"))
			{
				logger = extent.createTest("Login");
				logger.log(Status.INFO, "Verified Solnet login with valid credential");
				logger.log(Status.PASS, "login successfully");
 
			}else
			{
				logger = extent.createTest("Login"); 
				logger.log(Status.INFO, "Verified Solnet login with invalid credential ");
				logger.log(Status.FAIL, "lOGIN");
			}	 
	    
			Thread.sleep(3000);
			
			
			driver.findElement(By.className("hidden-xs")).click();
		    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Toggle navigation'])[1]/following::span[4]")).click();
		    driver.findElement(By.linkText("Sign out")).click();
			
			
			
		//	extent.flush();
}

	
	@Test( priority=2)
	public void login_with_invalid_data() throws IOException
	
	{
		repporter = new ExtentHtmlReporter("./Report/demo.html");
		extent = new ExtentReports();
		extent.attachReporter(repporter);
		driver.get("http://dev.eluminousdev.com/solnet_noc/login");
		driver.findElement(By.name("email")).click();
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys("invalid@gmail.com");
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("123456");
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='SOLNET'])[1]/following::input[5]")).click();
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Toggle navigation'])[1]/following::span[4]")).click();
		System.out.println("title is "+driver.getTitle());
        logger = extent.createTest("Login"); 
	    logger.log(Status.INFO, "Verified Solnet login with invalid credential ");
		logger.log(Status.PASS, "These credentials do not match our records.");
		extent.flush();
		driver.quit();
	}
	
		
		
		
		
	
	
	
	
	
	
	
	
	
}