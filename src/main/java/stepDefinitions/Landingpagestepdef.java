package stepDefinitions;

import context.DriverContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LandingPage;
import pages.PageFactoryManager;

public class Landingpagestepdef {
    private final LandingPage landingPage;

    public Landingpagestepdef(DriverContext dcontext){
        landingPage= PageFactoryManager.getLandingPage(dcontext.driver);
    }

    @When("I enter my username \"(.*)\" and password \"(.*)\"$")
    public void LogintoAccount(String username, String password){
        landingPage.closenewsletternotification();
        landingPage.loginMenuclick();
        landingPage.enterUsername(username);
        landingPage.enterPassword(password);
        landingPage.loginClick();
    }


    @Then("the user \"(.*)\" login in successfully$")
    public void theUserLoginInSuccessfully(String username) {
        Assert.assertEquals(landingPage.getUserloginlabel(),"Hello "+username+" (not "+username+"? Log out)");
    }
}
