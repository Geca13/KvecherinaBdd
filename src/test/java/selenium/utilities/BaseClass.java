package selenium.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BaseClass {

    private WebDriver driver;

    public BaseClass(WebDriver driver) {
        this.driver = driver;
    }


    public void visit(String url) {
        driver.get(url);
    }

    public WebElement find(By locator) {
        return driver.findElement(locator);
    }

    public void click(By locator) {
        find(locator).click();
    }

    public void type(String inputText, By locator) {
        find(locator).sendKeys(inputText);
    }

    public String getElementText(By locator){
        return this.find(locator).getText();
    }

    public Boolean isDisplayed(By locator, Integer timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        WebElement element = this.find(locator);
        if(element.isDisplayed()){
            return true;
        }
        return false;
    }

    public String returnBrowserUrl(){
        return this.driver.getCurrentUrl();
    }

    public Boolean classIsApplied(By locator, String toCheck){
        WebElement element = this.find(locator);
        String applied = element.getAttribute("class");
        String [] classes = applied.split(" ");
        for (int i = 0; i < classes.length; i++){
            if (classes[i].equals(toCheck)){
                return true;
            }
        }
        return false;
    }

    public String returnImageSrcValue(By locator){
        WebElement element = this.find(locator);
        return element.getAttribute("src");
    }

    public String getInputType(By locator){
        WebElement element = this.find(locator);
        return element.getAttribute("type");
    }

}
