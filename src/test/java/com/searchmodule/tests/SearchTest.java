package com.searchmodule.tests;

import com.aventstack.extentreports.Status;
import com.searchmodule.pages.SearchPage;
import com.tests.BaseTest;

import helper.ExtentTestManager;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {



	@Test(testName="SearchTest001",priority = 1, description = "TC_001 Search functionality on Duck Duck go Website")
	@Parameters({"keyword"})
	public void search(String keyword,Method method){
		//ExtentReports Description
		SearchPage searchPage = new SearchPage(driver);
		searchPage.goTo();
		ExtentTestManager.getTest().log(Status.INFO, "Open URL");
		searchPage.doSearch(keyword);
		searchPage.goToVideos();
		int size = searchPage.getResult();
		Assert.assertTrue(size > 0);
		ExtentTestManager.getTest().log(Status.INFO, "Test End");
	}

	@Test(testName="FailedSearchTest",priority = 0, description = "TC_002 Test Search functionality on Duck Duck go Website")
	@Parameters({"keyword"})
	public void searchfailuretest(String keyword,Method method){
		SearchPage searchPage = new SearchPage(driver);
		searchPage.goTo();
		ExtentTestManager.getTest().log(Status.INFO, "Open URL");
		searchPage.doSearch(keyword);
		searchPage.goToVideos();
		int size = searchPage.getResult();

		Assert.assertTrue(size > 0);
		ExtentTestManager.getTest().log(Status.INFO, "Test End");

	}


	







}
