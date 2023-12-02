package stepDefinitions;

import context.DriverContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.HomePage;
import pages.PageFactoryManager;
import utilities.ConfigLoader;

public class Homepagestepdef {
    private final HomePage homePage;

    public Homepagestepdef(DriverContext dcontext){
        homePage=PageFactoryManager.getHomePage(dcontext.driver);
    }

    @Given("I am on the Automation zone page")
    public void loadApplication(){
        homePage.load(ConfigLoader.getInstance().getURL());
    }


    @And("I log out from the application")
    public void iLogOutFromTheApplication() {
        homePage.signout();
    }
}
