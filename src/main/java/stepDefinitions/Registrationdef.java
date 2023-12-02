package stepDefinitions;

import context.DriverContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import pages.LandingPage;
import pages.PageFactoryManager;
import pages.RegistrationPage;

import java.util.List;
import java.util.Map;

public class Registrationdef {

    private final RegistrationPage registrationPage;
    private final LandingPage landingPage;

    public Registrationdef(DriverContext dcontext ){
        registrationPage= PageFactoryManager.getRegistrationPage(dcontext.driver);
        landingPage=PageFactoryManager.getLandingPage(dcontext.driver);
    }

    @Given("I am a new user")
    public void Iam_new_user(DataTable userregdata){
     List<Map<String,String>> data=  userregdata.asMaps(String.class,String.class);
     landingPage.closenewsletternotification();
     landingPage.loginMenuclick();
     registrationPage.switch_to_regustersection();
     registrationPage.set_regusername(data.get(0).get("username"));
     registrationPage.set_regemailaddress(data.get(0).get("email"));
     registrationPage.set_password(data.get(0).get("password"));
     registrationPage.register();
    }
}

