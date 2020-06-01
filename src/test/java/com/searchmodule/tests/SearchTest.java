package com.searchmodule.tests;

import com.relevantcodes.extentreports.LogStatus;
import com.searchmodule.pages.SearchPage;
import com.tests.BaseTest;

import helper.ExtentTestManager;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {
	
	public Test test;

    @Test(testName="SearchTest",priority = 0, description = "Search functionality on Duck Duck go Website")
    @Parameters({"keyword"})
    public void search(String keyword,Method method){
    	//ExtentReports Description
        ExtentTestManager.startTest(test.testName(),test.description());
        SearchPage searchPage = new SearchPage(driver);
        searchPage.goTo();
        ExtentTestManager.getTest().log(LogStatus.INFO, "Open URL");
        searchPage.doSearch(keyword);
        searchPage.goToVideos();
        int size = searchPage.getResult();

        Assert.assertTrue(size > 0);
        ExtentTestManager.getTest().log(LogStatus.INFO, "Test End");
    }
    
    @Test(testName="FailedSearchTest",priority = 1, description = "Search functionality on Duck Duck go Website")
    @Parameters({"keyword"})
    public void searchfailuretest(String keyword,Method method){
    	//ExtentReports Description
        ExtentTestManager.startTest(test.testName(),test.description());
        SearchPage searchPage = new SearchPage(driver);
        searchPage.goTo();
        ExtentTestManager.getTest().log(LogStatus.INFO, "Open URL");
        searchPage.doSearch(keyword);
        searchPage.goToVideos();
        int size = searchPage.getResult();

        Assert.assertTrue(size < 0);
        ExtentTestManager.getTest().log(LogStatus.INFO, "Test End");
    }






@BeforeMethod
public void beforeMethod(Method method) {
    test = method.getAnnotation(Test.class);
    System.out.println("Test name is " + test.testName());
    System.out.println("Test description is " + test.description());
}

}
