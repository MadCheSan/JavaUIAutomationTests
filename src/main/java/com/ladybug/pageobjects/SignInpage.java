package com.ladybug.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by aleksandr on 11/3/17.
 */
public class SignInpage {


    public Boolean RegistrButtonExist(WebDriver driver) {
        WebElement registrationButton = driver.findElement(By.cssSelector( "a.btn[href='/register'"));
        return registrationButton.isEnabled();
    }

    public void goToregistration(WebDriver driver) {
        WebElement registrationButton = driver.findElement(By.cssSelector("a.btn[href='/register'"));
        registrationButton.click();
    }

    public RegistrationPage clickRegisterButton(WebDriver driver) {
        WebElement registrationButton = driver.findElement(By.cssSelector("a.btn[href='/register'"));
        registrationButton.click();
        return PageFactory.initElements(driver, RegistrationPage.class);
    }

    public LoginPage loginButtonClick(WebDriver driver) {
        WebElement loginButton = driver.findElement(By.cssSelector("a.btn[href='/login'"));
        loginButton.click();
        return PageFactory.initElements(driver, LoginPage.class);
    }
}
