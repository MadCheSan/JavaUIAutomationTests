package com.ladybug.pageobjects;

import com.ladybug.util.WebUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by aleksandr on 11/4/17.
 */
public class LoginPage {
    public void fillUserName(WebDriver driver, String s) {
        WebUtil.sendKey(driver, By.cssSelector("input[name='username']") , s);
    }

    public void fillUserPassword(WebDriver driver, String s) {
        WebUtil.sendKey(driver, By.cssSelector("input[name='password']"), s);

    }

    public HomePage submitLoginButtonClick(WebDriver driver) {
        WebUtil.click(driver, By.cssSelector("input[value='Login']"));
        return PageFactory.initElements(driver, HomePage.class);
    }

    public HomePage fullLoginIn(WebDriver driver, String name, String pass){
        WebUtil.sendKey(driver,By.cssSelector("input[name='username']"),name);

        WebUtil.sendKey(driver, By.cssSelector("input[name='password']"), pass);

        WebUtil.click(driver, By.cssSelector("input[value='Login']"));
        return PageFactory.initElements(driver, HomePage.class);

    }

}
