package pages;

import org.openqa.selenium.WebDriver;

public class PageFactoryManager {
    private static LandingPage landingPage;
    private static HomePage homePage;

    private static RegistrationPage registrationPage;

    public static LandingPage getLandingPage(WebDriver driver){
        return landingPage==null?new LandingPage(driver):landingPage;
       //condition ? statement1:statement2
    }

    public static HomePage getHomePage(WebDriver driver){
        return homePage==null?new HomePage(driver):homePage;
    }

    public static RegistrationPage getRegistrationPage(WebDriver driver){
        return registrationPage==null? new RegistrationPage(driver):registrationPage;
    }
}
