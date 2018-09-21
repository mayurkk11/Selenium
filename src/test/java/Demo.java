
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Demo {
	ExtentHtmlReporter repporter;
    ExtentReports extent; 
	ExtentTest loger; 
	@Test
	public void extent_report()
	{
	    repporter = new ExtentHtmlReporter("./Report/demo.html");
	    extent = new ExtentReports();
	    extent.attachReporter(repporter);
	    loger = extent.createTest("Login");
	    loger.log(Status.INFO, "Login name");
	    loger.log(Status.PASS, "lOGIN");
	    loger.log(Status.FAIL, "lOG_OUT ");
	    loger.log(Status.PASS, "FORGOT PASSWORD");
	    
	    loger = extent.createTest("login-2");
	    
	    loger.log(Status.INFO, "Login name");
	    loger.log(Status.PASS, "lOGIN");
	    loger.log(Status.FAIL, "lOG_OUT ");
	    loger.log(Status.PASS, "FORGOT PASSWORD");
	    
	    
	    extent.flush();
         	
	
	}       
	
}
