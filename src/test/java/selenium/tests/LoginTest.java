package selenium.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.components.LoginModal;
import selenium.components.Navbar;
import selenium.pages.HomePage;

public class LoginTest {

    private HomePage home;
    private WebDriver driver;

    private Navbar navbar;

    private LoginModal login;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--no-sandbox");

        options.addArguments("--disable-gpu");

        options.addArguments("--window-size=1936,1080");

        options.addArguments("--headless");

        driver = new ChromeDriver(options);
        home = new HomePage(driver);
        navbar = new Navbar(driver);
        login = new LoginModal(driver);
        home.loadHomeUrl();
        navbar.clickLoginIcon();
        login.loginModalIsOpened();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void assertUserNameAndPasswordLabelsTexts(){
        Assert.assertEquals(this.login.passwordLabel(), "Лозинка");
        Assert.assertEquals(this.login.usernameLabel(), "Електронска Пошта");
    }

    @Test
    public void assertUserNameAndPasswordInputType(){
        Assert.assertEquals(login.getPasswordInputType(), "password");
        Assert.assertEquals(login.getUserNameInputType(), "email");
    }

    @Test
    public void assertFailLogin(){
        login.failLoginAsAdmin();
        Assert.assertEquals(home.returnHomePageBrowserUrl(), "https://zavodlivakvecherina.herokuapp.com/?error");
    }
}
