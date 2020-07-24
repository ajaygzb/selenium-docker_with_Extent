package com.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import helper.ExtentManager;
import helper.ExtentTestManager;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver;
    public static String Browsername;
    public Test test;
    @Parameters({"browser"})
    @BeforeTest
    public void setupDriver(ITestContext ctx,@Optional("chrome")String browser) throws MalformedURLException {
        // BROWSER => chrome / firefox
        // HUB_HOST => localhost / 10.0.1.3 / hostname

    	String host = "localhost";
        DesiredCapabilities dc;

        if(System.getProperty("BROWSER") != null &&
                System.getProperty("BROWSER").equalsIgnoreCase("firefox")){
            dc = DesiredCapabilities.firefox();
        }else{
            dc = DesiredCapabilities.chrome();
        }

        if(System.getProperty("HUB_HOST") != null){
            host = System.getProperty("HUB_HOST");
            String testName = ctx.getCurrentXmlTest().getName();

            String completeUrl = "http://" + host + ":4444/wd/hub";
            dc.setCapability("name", testName);
            this.driver = new RemoteWebDriver(new URL(completeUrl), dc);
        }
        else{
        	
        	if(browser.equalsIgnoreCase("chrome")) {
        	WebDriverManager.chromedriver().setup();
    		driver= new ChromeDriver();
    		driver.manage().window().maximize();
    		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    		 System.out.println("Browser Name is : "+((RemoteWebDriver) driver).getCapabilities().getBrowserName().toLowerCase());
    	     System.out.println("Browser Version is : "+((RemoteWebDriver) driver).getCapabilities().getVersion().toString());
    	     System.out.println("Platform Name is : "+((RemoteWebDriver) driver).getCapabilities().getPlatform().toString());
    		Browsername=((RemoteWebDriver) driver).getCapabilities().getBrowserName().toUpperCase();
        	}
        	else if(browser.equalsIgnoreCase("firefox")) {
            	WebDriverManager.firefoxdriver().setup();
        		driver= new FirefoxDriver();
        		driver.manage().window().maximize();
        		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        		 System.out.println("Browser Name is : "+((RemoteWebDriver) driver).getCapabilities().getBrowserName().toLowerCase());
        	     System.out.println("Browser Version is : "+((RemoteWebDriver) driver).getCapabilities().getVersion().toString());
        	     System.out.println("Platform Name is : "+((RemoteWebDriver) driver).getCapabilities().getPlatform().toString());
        		Browsername=((RemoteWebDriver) driver).getCapabilities().getBrowserName().toUpperCase();
            	}
    	
        	
        }

       
    }
    
    public WebDriver getDriver() {
        return driver;
    }

    @AfterTest
    public void quitDriver(){
        this.driver.quit();
    }
    
	
    @BeforeMethod public void beforeMethod(Method method) { 
    	test =method.getAnnotation(Test.class); System.out.println("Test name is " +
		test.testName()); System.out.println("Test description is " +test.description());
		ExtentTestManager.startTest(test.testName(),test.description());
		ExtentTestManager.getTest().assignCategory(BaseTest.Browsername);
		ExtentTestManager.getTest().assignAuthor("Ajay Kumar");
		ExtentTestManager.getTest().assignDevice(((RemoteWebDriver)driver).getCapabilities().getPlatform().toString());


	}

	  
	  @AfterMethod public void AfterMethod(Method method) {
		  ExtentManager.getReporter().flush();
	      //ExtentTestManager.endTest();
	  
	  }
	 


}
