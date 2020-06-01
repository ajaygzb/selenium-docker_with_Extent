/*package com.n11.homepage;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import helper.Helper;
 
public class HomePage extends Helper {
 
    *//**Constructor*//*
    public HomePage(WebDriver driver) {
        super(driver);
    }
 
    *//**Variables*//*
    String baseURL = "http://www.n11.com/";
 
    *//**Web Elements*//*
    By signInButtonClass = By.className("btnSignIn");
    By modal = By.xpath("//*[@id=\"userKvkkModal\"]/div/div[2]/span");
 
    *//**Page Methods*//*
    public HomePage goToN11() {
        driver.get(baseURL);
        if(driver.findElement(modal).isDisplayed()) {
            click(modal);
        }
        return this;
    }
 
    public LoginPage goToLoginPage() {
        click(signInButtonClass);
        return new LoginPage(driver);
    }
}*/