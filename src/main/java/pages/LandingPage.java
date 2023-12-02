package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LandingPage extends BasePage {

    @FindBy(css="#mf-newsletter-popup>div+div>a")
    private WebElement closenotificationLink;

    @FindBy(css=".extras-menu>li+li+li")
    private WebElement loginMenuLink;

    @FindBy(id="username")
    private WebElement userNameText;

    @FindBy(id="password")
    private WebElement passwordText;

    @FindBy(xpath = "//button[text()='Log in']")
    private WebElement loginButton;

    @FindBy(xpath = "//p[text()[contains(.,'Hello')]]")
    private WebElement loginSuccessLabel;
    public LandingPage(WebDriver driver)
    {
      super(driver);

    }

    public void closenewsletternotification(){
        wait.until(ExpectedConditions.visibilityOf(closenotificationLink));
        wait.until(ExpectedConditions.elementToBeClickable(closenotificationLink));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", closenotificationLink);
        closenotificationLink.click();
    }

    public void loginMenuclick(){
        wait.until(ExpectedConditions.visibilityOf(loginMenuLink));
        wait.until(ExpectedConditions.elementToBeClickable(loginMenuLink));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",loginMenuLink);
        loginMenuLink.click();
    }

    public void enterUsername(String username){
        wait.until(ExpectedConditions.visibilityOf(userNameText));
        userNameText.sendKeys(username);
    }
    public void enterPassword(String password){
        wait.until(ExpectedConditions.visibilityOf(passwordText));
        passwordText.sendKeys(password);
    }

    public void loginClick(){
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
    }

    public String getUserloginlabel(){
        return wait.until(ExpectedConditions.visibilityOf(loginSuccessLabel)).getText();
    }

}
