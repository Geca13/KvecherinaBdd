package selenium.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import selenium.utilities.BaseClass;

public class Navbar extends BaseClass {

    public Navbar(WebDriver driver) {
        super(driver);
    }

    By navbar = By.xpath("//nav[@class='navbar']");

    By newShowLink = By.xpath("//a[@href='/new']");

    By loginIcon = By.xpath("//a[@id='login-open-popup']//i");

    By navLogoImage = By.xpath("//a[@href='/']//img");

    By allShowsLink = By.xpath("//a[@href='/all']");

    By allPerformersLink = By.xpath("//a[@href='/artists']");


    public Boolean iSeeTheNavbarComponent() {
       return this.isDisplayed(navbar, 5);
    }


    public Boolean iSeeAllShowsLink() {
       return this.isDisplayed(allShowsLink, 5);
    }


    public Boolean iSeeAllPerformersLink() {
       return this.isDisplayed(allPerformersLink, 5);
    }

    public Boolean iSeeNavbarLogoImage() {
       return this.isDisplayed(navLogoImage, 5);
    }

    public Boolean iSeeLoginIcon() {
       return this.isDisplayed(loginIcon, 5);
    }

    public String firstNavTextEquals() {
      return this.getElementText(allShowsLink);
    }

    public String getNavBarLogo() {
        return this.returnImageSrcValue(navLogoImage);
    }

    public Boolean iconContainsClass() {
       return this.classIsApplied(loginIcon, "fa-sign-in");
    }

    public String secondNavTextEquals() {
       return this.getElementText(allPerformersLink);
    }

    public void clickLoginIcon(){
        this.iSeeLoginIcon();
        this.click(loginIcon);
    }
}
