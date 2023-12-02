package stepDefinitions;

import com.jayway.jsonpath.JsonPath;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class Authenticationdef {

    @Given("a registered user with user id \"(.*)\" and password \"(.*)\"$")
    public void login(String userName, String password){
        System.out.println(userName);
        System.out.println(password);
    }

    @When("the user enters the credentials and clicks on the submit button")
    public void theUserEntersTheCredentialsAndClicksOnTheSubmitButton() {
        System.out.println("I am in the login page");

    }

    @Then("the system should authenticate the user")
    public void theSystemShouldAuthenticateTheUser() {
        System.out.println("I am in the step3");
    }

    @Given("I am registered user with username \"(.*)\" and with password \"(.*)\"$")
    public void iAmRegisteredUserWithUsernameAndWithPassword(String username, String password) {
        System.out.println(username);
        System.out.println(password);
    }

    @Given("the user is on homepage")
    public void theUserIsOnHomepage(DataTable userCreds) {
      List<List<String>> data= userCreds.asLists();
      System.out.println(data.get(0).get(0));
      System.out.println(data.get(0).get(1));
      System.out.println(data.get(1).get(0));
      System.out.println(data.get(1).get(1));

    }

    @Given("the user entered the creds")
    public void theUserEnteredTheCreds(DataTable creds) {
     List<Map<String,String>> data=creds.asMaps(String.class,String.class);
        System.out.println(data.get(0).get("userid"));
        System.out.println(data.get(0).get("password"));
        System.out.println(data.get(1).get("userid"));
        System.out.println(data.get(1).get("password"));
    }

    @Given("the user entered the JSON test data")
    public void theUserEnteredTheJSONTestData(String jsonData) {
        String userName1=JsonPath.parse(jsonData).read("$.users[0].name");
        System.out.println(userName1);

        String userName2=JsonPath.parse(jsonData).read("$.users[1].name");
        System.out.println(userName2);

        int age1=JsonPath.parse(jsonData).read("$.users[0].age");
        int age2=JsonPath.parse(jsonData).read("$.users[1].age");
        System.out.println(age1);
        System.out.println(age2);

    }
}
