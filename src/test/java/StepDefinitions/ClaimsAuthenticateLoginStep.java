package StepDefinitions;

import PageObjects.ClaimsAuthenticateLogin;
import PageObjects.ClienteleLifeClaims;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.pages.PageObject;

public class ClaimsAuthenticateLoginStep extends PageObject {

    @Steps
    ClaimsAuthenticateLogin claimsAuthenticateLogin;
    ClienteleLifeClaims clienteleLifeClaims;


    @Given("user authenticate by signing in with valid Username and Password")
    public void user_authenticate_by_signing_in_with_valid_username_and_password() throws InterruptedException {
        claimsAuthenticateLogin.OpenWebsite();

    }

    @When("user search policies using valid details")
    public void user_search_policies_using_valid_details() throws InterruptedException {
        claimsAuthenticateLogin.SearchField("611038928");
        clienteleLifeClaims.Details();
        clienteleLifeClaims.PolicyTab();
        clienteleLifeClaims.ActivePolicy();
        clienteleLifeClaims.PolicyIndividualTab();
        clienteleLifeClaims.IntimateClaimBtn();
        clienteleLifeClaims.SelectInformationMethod("Telephonic");
        clienteleLifeClaims.selectClaim("Mars, Star");
        clienteleLifeClaims.selectRelationship("Member");
        clienteleLifeClaims.selectInsuredLife("Mngemela, Thulisile Charlott (2002/01/04)");
        clienteleLifeClaims.ClaimType();
        clienteleLifeClaims.DeathReason();
        clienteleLifeClaims.DateOfDeath("05/01/2024");
        clienteleLifeClaims.IntimateBtn();
        clienteleLifeClaims.newClaimant();
        clienteleLifeClaims.enterFirstName("Nancy");
        clienteleLifeClaims.enterSurname("Roberts");
        clienteleLifeClaims.selectTittle("Miss");


    }

}
