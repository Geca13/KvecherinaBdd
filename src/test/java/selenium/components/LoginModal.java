package selenium.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import selenium.utilities.BaseClass;

public class LoginModal extends BaseClass {
    public LoginModal(WebDriver driver) {
        super(driver);
    }

    By modal = By.className("content");
    By usernameInput = By.name("username");
    By passwordInput = By.name("password");
    By submitBtn = By.xpath("//button[@type='submit']");

    By usernameLabel = By.xpath("(//label)[1]");

    By passwordLabel = By.xpath("(//label)[2]");

    public void loginModalIsOpened(){
        this.isDisplayed(modal, 5);
    }

    public void loginAsAdmin(){
        this.type("email1@email.com", usernameInput);
        this.type("Password@123", passwordInput);
        this.click(submitBtn);
    }

    public void failLoginAsAdmin(){
        this.type("email99@email.com", usernameInput);
        this.type("Password@123", passwordInput);
        this.click(submitBtn);
    }

    public Boolean usernameInputIsDisplayed(){
        return this.isDisplayed(usernameInput, 5);
    }

    public String getUserNameInputType(){
        return this.getInputType(usernameInput);
    }

    public Boolean passwordInputIsDisplayed(){
        return this.isDisplayed(passwordInput, 5);
    }

    public String passwordLabel(){
        return this.getElementText(passwordLabel);
    }

    public String usernameLabel(){
        return this.getElementText(usernameLabel);
    }

    public String getPasswordInputType(){
        return this.getInputType(passwordInput);
    }
}
