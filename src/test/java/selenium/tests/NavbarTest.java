package selenium.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.components.Navbar;
import selenium.pages.HomePage;


public class NavbarTest {

    private HomePage home;
    private WebDriver driver;

    private Navbar navbar;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        home = new HomePage(driver);
        home.loadHomeUrl();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();;
    }

    @Test
    public void navbarIsDisplayedAfterPageIsLoaded(){
        navbar = new Navbar(driver);
        Assert.assertTrue(navbar.iSeeTheNavbarComponent());
    }

    @Test
    public void assertAllShowsNavLinkIsDisplayedAndAssertText(){
        navbar = new Navbar(driver);
        Assert.assertTrue(navbar.iSeeAllShowsLink());
        Assert.assertEquals(navbar.firstNavTextEquals(), "Емисии");
    }

    @Test
    public void assertAllPerformersNavLinkIsDisplayedAndAssertText(){
        navbar = new Navbar(driver);
        Assert.assertTrue(navbar.iSeeAllPerformersLink());
        Assert.assertEquals(navbar.secondNavTextEquals(), "Изведувачи");
    }

    @Test
    public void assertLoginNavLinkIsDisplayedAndAssertLoginIconClassName(){
        navbar = new Navbar(driver);
        Assert.assertTrue(navbar.iSeeLoginIcon());
        Assert.assertTrue(navbar.iconContainsClass());
    }

}
