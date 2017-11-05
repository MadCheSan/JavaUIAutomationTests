package com.ladybug.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by aleksandr on 11/3/17.
 */
public class RegistrationPage {

    public void fillUserNAmeField(WebDriver driver, String usrName) {
        WebElement userNameTextBox = driver.findElement(By.cssSelector("input[id='user_username']"));
        userNameTextBox.clear();
        userNameTextBox.sendKeys(usrName);
    }

    public void fillPassField(WebDriver driver, String pass) {
        WebElement userPasswordTextBox = driver.findElement(By.cssSelector("input[id='user_password']"));
        userPasswordTextBox.clear();
        userPasswordTextBox.sendKeys(pass);
    }

    public void fillPassConfirmField(WebDriver driver, String passConf) {
        WebElement confirmPasswTextBox = driver.findElement(By.cssSelector("input[id='user_password_confirmation"));
        confirmPasswTextBox.clear();
        confirmPasswTextBox.sendKeys(passConf);
    }

    public boolean userNameFieldIsEnabled(WebDriver driver) {
        WebElement userNameTextBox = driver.findElement(By.cssSelector("input[id='user_username']"));
        return userNameTextBox.isEnabled();
    }

    public boolean submitRegisterButtonEnabled(WebDriver driver){

        WebElement inputRegisterButton = driver.findElement(By.cssSelector("input.btn-success"));
        return inputRegisterButton.isEnabled();
    }

    public HomePage submitRegisterButtonClick(WebDriver driver) {
        WebElement submitRegisterButton = driver.findElement(By.cssSelector("input.btn-success"));
        submitRegisterButton.click();
        return PageFactory.initElements(driver, HomePage.class);
    }
}
