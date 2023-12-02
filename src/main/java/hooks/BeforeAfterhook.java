package hooks;

import context.DriverContext;
import driverFactory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Scanner;

public class BeforeAfterhook {
    private WebDriver driver;

    private final DriverContext dcontext;

    public BeforeAfterhook(DriverContext dcontext) {
        this.dcontext=dcontext;
    }

    @Before
    public void before(Scenario scenario){
        driver= DriverFactory.initializeDriver(System.getProperty("browser","firefox"));
        dcontext.driver=driver;
    }

    @After
    public void after(Scenario scenario){
        driver.quit();
    }

    @After
    public void addScreenshot(Scenario scenario){
        if(scenario.isFailed()){
            final byte[] screenshots= ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshots,"image/png","image");
        }
    }
}
