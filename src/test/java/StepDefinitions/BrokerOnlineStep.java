package StepDefinitions;

import PageObjects.BrokerOnline;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.pages.PageObject;

public class BrokerOnlineStep extends PageObject {

    @Steps
    BrokerOnline brokerOnline;

    @Given("user open Broker Online Website")
    public void user_open_broker_online_website() throws InterruptedException {
        brokerOnline.OpenWebsite();

    }
    @When("user enter access code and confirm,{string}")
    public void user_enter_access_code_and_confirm(String string) {
        brokerOnline.enterCode(string);

    }

    @Then("user Login with valid Broker code and password")
    public void user_login_with_valid_broker_code_and_password() throws InterruptedException {
       brokerOnline.brokerCode("B1234");
       brokerOnline.password("12345");

    }

    @When("user click on new sale")
    public void user_click_on_new_sale() throws InterruptedException {
        brokerOnline.newSale();

    }
    @When("user select product on a dropdown lists")
    public void user_select_product_on_a_dropdown_lists() throws InterruptedException {
        brokerOnline.selectProduct("Clientèle Legal Business Plan");
        brokerOnline.continueBtn();


    }
    @Then("user enter application number and continue")
    public void user_enter_application_number_and_continue() throws InterruptedException {
        //brokerOnline.continueBtn();
        brokerOnline.companyName("TRY");
        brokerOnline.businessType("Churches");
        brokerOnline.textNum("8908038462087");
        brokerOnline.employeeNum("12");
        brokerOnline.mobNumb("0601234230");
        brokerOnline.workNum("0601234230");
        brokerOnline.annualTurnOver("Less than 2,000,000");
        brokerOnline.address("AB 12", "polei", "plot 3");
        brokerOnline.underWriting("0", "Yes", "Yes", "Education & Training", "Biblical manner");
        brokerOnline.detailsForm("Mr","98080394551810");
        brokerOnline.iDPassNumber("ID Number");
        brokerOnline.completeForm("Joe", "Masemola", "0601234101", "Member", "Yes");

    }

}
