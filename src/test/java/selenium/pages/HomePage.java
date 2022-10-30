package selenium.pages;


import org.openqa.selenium.WebDriver;
import selenium.utilities.BaseClass;

public class HomePage extends BaseClass {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void loadHomeUrl(){
        this.visit("https://zavodlivakvecherina.herokuapp.com/");
    }

    public String returnHomePageBrowserUrl(){
        return this.returnBrowserUrl();
    }


}
