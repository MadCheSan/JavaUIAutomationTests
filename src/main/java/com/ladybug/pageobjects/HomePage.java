package com.ladybug.pageobjects;

import com.ladybug.util.WebUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by aleksandr on 11/4/17.
 */
public class HomePage {

    public boolean logoutButtonIsExist(WebDriver driver) {
        return driver.findElement(By.cssSelector("a.btn[href='/logout']")).isEnabled();
    }

    public EditProfilePage editProfileClick(WebDriver driver) {
        WebUtil.click(driver, By.cssSelector("a.btn[data-toggle]"));
        return PageFactory.initElements(driver, EditProfilePage.class);
    }
}
