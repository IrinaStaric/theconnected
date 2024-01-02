package theconnectedshop;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class NegativeRegistration {
    private WebDriver driver;
    private HomePageTest homePageTest;
    private RegistrationPage registrationPage;

    public NegativeRegistration (HomePageTest homePageTest) {
        this.homePageTest = homePageTest;
        this.registrationPage = new RegistrationPage(homePageTest.getDriver());
    }
    @When("the user fills in the following invalid registration details")
    public void fillInvalidDetails(DataTable dataTable) {
        List<Map<String, String>> registrationDataList = dataTable.asMaps(String.class, String.class);
        Map<String, String> registrationData = registrationDataList.get(0);

        registrationPage.fillRegistrationForm(
                registrationData.get("First Name"),
                registrationData.get("Last Name"),
                registrationData.get("Email"),
                registrationData.get("Password")
        );
    }
    @Then("the user should see the warning message")
    public void verifyWarningsInRegistration(){
        registrationPage.warningMessage("password is too short (minimum is 5 characters) email is invalid");
    }
    @And("the user fills in the following empty registration details")
    public void fillEmptyDetails(DataTable dataTable) {
        List<Map<String, String>> registrationDataList = dataTable.asMaps(String.class, String.class);
        Map<String, String> registrationData = registrationDataList.get(0);

        registrationPage.fillRegistrationForm(
                registrationData.get("First Name"),
                registrationData.get("Last Name"),
                registrationData.get("Email"),
                registrationData.get("Password")
        );
    }
    @Then("the user should see the tooltip message")
    public void verifyTooltipsInRegistration(){
        registrationPage.warningMessage("Please fill in this field");
    }
}
