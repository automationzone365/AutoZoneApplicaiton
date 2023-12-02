package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationPage extends BasePage {

    @FindBy(xpath="//*[@class='martfury-login-tabs']//a[text()='Register']")
    private WebElement registerRegsectionlink;

    @FindBy(css="#reg_username")
    private WebElement regUsernameTextbox;

    @FindBy(css="#reg_email")
    private WebElement regEmailTextbox;

    @FindBy(css="#reg_password")
    private WebElement regPasswordTextBox;

    @FindBy(css="button[name='register']")
    private WebElement registeButton;

    public RegistrationPage(WebDriver driver){
        super(driver);
    }

    public void switch_to_regustersection(){
        wait.until(ExpectedConditions.visibilityOf(registerRegsectionlink));
        wait.until(ExpectedConditions.elementToBeClickable(registerRegsectionlink));
        registerRegsectionlink.click();
    }

    public void set_regusername(String username){
        wait.until(ExpectedConditions.visibilityOf(regUsernameTextbox));
        regUsernameTextbox.sendKeys(username);
    }

    public void set_regemailaddress(String regEmail){
        wait.until(ExpectedConditions.visibilityOf(regEmailTextbox));
        regEmailTextbox.sendKeys(regEmail);
    }

    public void set_password(String regpassword){
        wait.until(ExpectedConditions.visibilityOf(regPasswordTextBox));
        regPasswordTextBox.sendKeys(regpassword);
    }

    public void register(){
        wait.until(ExpectedConditions.visibilityOf(registeButton));
        wait.until(ExpectedConditions.elementToBeClickable(registeButton));
        registeButton.click();
    }
}
