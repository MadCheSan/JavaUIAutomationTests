package com.ladybug.pageobjects;

import com.ladybug.util.WebUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by aleksandr on 11/3/17.
 */
public class SignInpage {


    public Boolean RegistrButtonExist(WebDriver driver) {
        return WebUtil.isElementExist(driver,By.cssSelector( "a.btn[href='/register'"));
    }

    public void goToregistration(WebDriver driver) {
        WebUtil.click(driver, By.cssSelector("a.btn[href='/register'"));
    }

    public RegistrationPage clickRegisterButton(WebDriver driver) {
        WebUtil.click(driver, By.cssSelector("a.btn[href='/register'"));
        return PageFactory.initElements(driver, RegistrationPage.class);
    }

    public LoginPage loginButtonClick(WebDriver driver) {
        WebUtil.click(driver, By.cssSelector("a.btn[href='/login'"));
        return PageFactory.initElements(driver, LoginPage.class);
    }
}
