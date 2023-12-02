package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{

    @FindBy(css="li.woocommerce-MyAccount-navigation-link--customer-logout>a")
    private WebElement logoutLink;

    public HomePage(WebDriver driver){
        super(driver);
    }

    public void load(String url){
        driver.get(url);
    }

    public void signout(){
        wait.until(ExpectedConditions.visibilityOf(logoutLink));
        wait.until(ExpectedConditions.elementToBeClickable(logoutLink));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",logoutLink);
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();",logoutLink);
    }
}
