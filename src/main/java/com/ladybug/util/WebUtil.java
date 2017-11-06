package com.ladybug.util;

import com.ladybug.pageobjects.LoginPage;
import com.ladybug.pageobjects.RegistrationPage;
import com.ladybug.pageobjects.SignInpage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by aleksandr on 11/3/17.
 */
public class WebUtil {
    public static SignInpage goToSignInPage(WebDriver driver) {
        driver.get("https://lc-ladybug.herokuapp.com/");
        return PageFactory.initElements(driver, SignInpage.class);
    }

    public static LoginPage goToLoginPage(WebDriver driver) {
        driver.get("https://lc-ladybug.herokuapp.com/login");
        return PageFactory.initElements(driver, LoginPage.class);

    }




    public static RegistrationPage goToRegistrationInPage(WebDriver driver) {
        driver.get("https://lc-ladybug.herokuapp.com/register");
        return PageFactory.initElements(driver, RegistrationPage.class);
    }

    public static void click(WebDriver driver, By by) {
        WebElement element = driver.findElement(by);
        element.click();
    }

    public static void sendKey(WebDriver driver, By by, String s) {
        WebElement element = driver.findElement(by);
        element.clear();
        element.sendKeys(s);
    }

    public static boolean isEnabled(WebDriver driver, By by) {
        WebElement element = driver.findElement(by);
        return element.isEnabled();
    }

    public static boolean isElementExist(WebDriver driver,By by){
        return driver.findElements(by).size() > 0;
    }

    public static int quantityOfElements(WebDriver driver, By by) {
        return driver.findElements(by).size();
    }
}
