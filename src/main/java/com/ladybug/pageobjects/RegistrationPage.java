package com.ladybug.pageobjects;

import com.ladybug.util.WebUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by aleksandr on 11/3/17.
 */
public class RegistrationPage {

    public void fillUserNAmeField(WebDriver driver, String usrName) {
        WebUtil.sendKey(driver, By.cssSelector("input[id$='_username']"), usrName);
    }

    public void fillPassField(WebDriver driver, String pass) {
        WebUtil.sendKey(driver, By.cssSelector("input[id$='_password']"), pass);
    }

    public void fillPassConfirmField(WebDriver driver, String passConf) {
        WebUtil.sendKey(driver, By.cssSelector("input[id$='_confirmation']"), passConf);
    }

    public boolean userNameFieldIsEnabled(WebDriver driver) {
        return WebUtil.isElementExist(driver,By.cssSelector("input[id$='_username']"));
    }

    public boolean submitRegisterButtonEnabled(WebDriver driver){
        return WebUtil.isElementExist(driver, By.cssSelector("input.btn-success"));
    }

    public HomePage submitRegisterButtonClick(WebDriver driver) {
        WebUtil.click(driver, By.cssSelector("input.btn-success"));
        return PageFactory.initElements(driver, HomePage.class);
    }
}
