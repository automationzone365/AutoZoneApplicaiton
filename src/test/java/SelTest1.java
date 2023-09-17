import driverFactory.DriverFactory;
import org.openqa.selenium.WebDriver;

import java.util.Scanner;

public class SelTest1 {

    public static void main(String args[]){
        WebDriver driver;
        System.out.println("Enter the browser");
        Scanner sc= new Scanner(System.in);
        String browser=sc.nextLine();

        driver=DriverFactory.initializeDriver(browser);
        driver.get("httP://www.automationzone.in");
    }
}
