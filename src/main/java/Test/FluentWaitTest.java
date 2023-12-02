package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.Date;
import java.util.NoSuchElementException;

public class FluentWaitTest {
    public static void main(String args[]){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver= new FirefoxDriver();
        driver.get("https://automationzone.in/");
        long startTime=0;
        long endTime=0;
        try {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(20))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            Date date1= new Date();
            startTime=date1.getTime();
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mf-newsletter-popup>div>div>a")));
            WebElement element=driver.findElement(By.cssSelector("#mf-newsletter-popup>div>div>a"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            element.click();
            driver.quit();
        }
        catch(Exception ex) {
            System.out.println("Timmed out");
            ex.printStackTrace();
            Date date2 = new Date();
            endTime = date2.getTime();
            System.out.println(endTime - startTime);
            driver.quit();
        }

    }
}
