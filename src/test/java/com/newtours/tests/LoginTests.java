/*package com.newtours.tests;
import java.lang.reflect.Method;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.n11.homepage.HomePage;
import com.tests.BaseTest;
 
public class LoginTests extends BaseTest {
	public HomePage homePage;
    // Extra information:
    // 1) @BeforeClass we declared driver variable.
    // 2) We send driver variable to the page class with below declaration.
    //    Homepage homepage = new HomePage(driver);
    // 3) super () method in page class transfer the driver variable value to the BasePage class.
 
	@BeforeMethod
    public void methodLevelSetup() {
        homePage = new HomePage(driver);
    }
	
	@Test(priority = 0, description = "Invalid Login Scenario with wrong username and password.")
    public void invalidLoginTest_InvalidUserNameInvalidPassword() {
 
        homePage
            .goToN11()
            .goToLoginPage()
            .loginToN11("onur@swtestacademy.com", "11223344")
            .verifyLoginPassword("E-posta adresiniz veya ?ifreniz hatal?");
    }
 
    @Test(priority = 1, description = "Invalid Login Scenario with empty username and password.")
    public void invalidLoginTest_EmptyUserEmptyPassword() {
      
        homePage
            .goToN11()
            .goToLoginPage()
            .loginToN11("", "")
            .verifyLoginUserName("Lütfen e-posta adresinizi girin.")
            .verifyLoginPassword("WRONG MESSAGE FOR FAILURE!");
    }
}*/