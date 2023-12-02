import driverFactory.DriverFactory;
import org.openqa.selenium.WebDriver;
import pages.LandingPage;
import pages.PageFactoryManager;
import utilities.ConfigLoader;
import java.util.Scanner;

public class SelTest1 {
    private static LandingPage landingPage;
    public static void main(String args[]) throws InterruptedException {
        WebDriver driver;
        System.out.println("Enter the browser");
        Scanner sc= new Scanner(System.in);
        String browser=sc.nextLine();

        driver=DriverFactory.initializeDriver(browser);
        String url= ConfigLoader.getInstance().getURL();
        String username=ConfigLoader.getInstance().getUsername();
        String password=ConfigLoader.getInstance().getPassword();
        driver.get(url);
        landingPage=PageFactoryManager.getLandingPage(driver);
        landingPage.closenewsletternotification();
        landingPage.loginMenuclick();
        landingPage.enterUsername(username);
        landingPage.enterPassword(password);
        landingPage.loginClick();
    }
}
