import com.ladybug.pageobjects.*;
import com.ladybug.util.WebUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Tests {
    public static WebDriver driver;

    //public HomePage homepage = new HomePage();
    @BeforeSuite
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void canGoToStartPage(){
        SignInpage signInpage = WebUtil.goToSignInPage(driver);
        Assert.assertEquals("LadyBug", driver.getTitle());
    }

    @Test
    public void registerAndLoginButtonsShouldBePresented() throws InterruptedException {
        SignInpage signInpage = WebUtil.goToSignInPage(driver);
        Assert.assertTrue( signInpage.RegistrButtonExist(driver), "Registration button shoul be exist");
        //Assert.assertTrue(isPresentedRegisterButton());
    }

    @Test
    public void canGoToRegistration(){
        SignInpage signInpage = WebUtil.goToSignInPage(driver);
        RegistrationPage regPage = signInpage.clickRegisterButton(driver);
        //check for RegisterSubmit button is displayed
        Assert.assertTrue(regPage.submitRegisterButtonEnabled(driver));
    }

    @Test
    public void canRegisterWithCorrectData() throws InterruptedException {
        RegistrationPage registrationPage = WebUtil.goToRegistrationInPage(driver);
        registrationPage.fillUserNAmeField(driver, "Alex auto");//data need to be changed for next execution

        registrationPage.fillPassField(driver, "San777");//data need to be changed for next execution

        registrationPage.fillPassConfirmField(driver, "San777");//data need to be changed for next execution


        HomePage homePage = registrationPage.submitRegisterButtonClick(driver);
        Thread.sleep(10000);
        Assert.assertTrue(homePage.logoutButtonIsExist(driver), "Login button should be exist");
        //Assert.assertTrue();
    }
    @Test
    public void logIn(){
        SignInpage signInpage = WebUtil.goToSignInPage(driver);
        //click login button & create new page
        LoginPage loginPage = signInpage.loginButtonClick(driver);
        //find and fill the UserName field
        loginPage.fillUserName(driver, "Alex auto");
        //then pass field
        loginPage.fillUserPassword(driver,"San777");
        //and going to homePage by click submitLoginButton "Login"
        HomePage homePage = loginPage.submitLoginButtonClick(driver);
        Assert.assertTrue(homePage.logoutButtonIsExist(driver), "Logout button should be exist");
    }
    @Test
    public void editPrifile(){
        //login и от него перейти на хоумпейдж
        LoginPage loginPage = WebUtil.goToLoginPage(driver);

        HomePage homePage = loginPage.fullLoginIn(driver, "Alex auto", "San777");

        Assert.assertTrue(WebUtil.isEnabled(driver, By.cssSelector("a.btn[data-toggle]")), "Profile button should be Enabled");

        EditProfilePage editProfilePage = homePage.editProfileClick(driver);
        //verify Edit Profile button
        Assert.assertTrue(WebUtil.isEnabled(driver, By.cssSelector("a[href^='/users'][href$='/edit']")), "Edit Profile in Drop-dawn");
        //some thing lIKE wait ~= implicityWait :)

    }

    

    @AfterSuite
    public void cleanUp(){
        driver.quit();
    }

}

