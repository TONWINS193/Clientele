package starter.PageObjects;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class ClienteleLifeClaims extends PageObject {
    String PolicyTabXpath = "//*[@id=\"MainDiv\"]/div[9]/div/div/ul/li[3]/a";
    String DetailsXpath = "//*[@id=\"main\"]/div[2]/div/table/tbody/tr[1]/td[8]/a";
    String ActivePolicyXpath = "//*[@id=\"accordionPolicy\"]/div/div[1]/h3/a";

    String PolicyIndividualXpath = "//*[@id=\"tab-details-611038928\"]/div/div/ul/li[2]/a";

    String IntimateClaimBtnXpath = "//*[@id=\"MainDiv\"]/div[1]/div/div/div/div[2]/button";
    String SelectInformationMethodXpath = "//select[@id='IntimationMethod']";

    String SelectClaimantXpath = "//select[@id='Claimant']";
    String SelectRelationshipXpath = "//select[@id='Relationship']";
    String SelectInsuredLifeXpath = "//select[@id='InsuredLife']";
    String ClaimTypeTabXpath = "//*[@id=\"Death\"]";
    String TypefDeathXpath = "//*[@id=\"Death-step1\"]/div/div/button[1]";
    String DateOfDeathXpath = "//input[@id='dateEvent']";
    //String DatePickerXpath = "//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[4]/a";

    String IntimateBtnXpath = "//*[@id=\"intimateClaimButton\"]";
    String AddNewClaimantXpath = "//*[@id=\"MainDiv\"]/div[1]/div/div/div/div[1]/button";

    String FirstNameXpath = "//*[@id=\"FirstName\"]";
    String SurnameXpath = "//*[@id=\"Surname\"]";
    String CTitleXpath = "//select[@id='Title']";
    String CIdNumberXpath = "//*[@id=\"IdNumber\"]";
    String CCellNumberXpath = "//*[@id=\"CellNumber\"]";
    String CEmailAddressXpath = "//*[@id=\"EmailAddress\"]";
    String CreateClaimantXpath = "//*[@id=\"formSubmit\"]";


    String ClaimGroupDetailsXpath = "//*[@id=\"tab-claimEvents\"]/div/div/div[1]/div[1]/h3/a";
    String UsermanagementURLXpath = "http://claimstest.clientele.local/usermanagement";

    String FindUserXpath = "//*[@id=\"main\"]/div[2]/div/table/tbody/tr[618]";

    String UpdateUserDetailsXpath = "//*[@id=\"main\"]/div[2]/div/table/tbody/tr[618]/td[6]/button";

    String UserRoleXpath = "//select[@id='UserRole']";
    String SaveBtnXpath = "//*[@id=\"modalFormSubmit\"]";

    String ABurgerMenuXpath = "//*[@id=\"tab-claimEvents\"]/div/div/div[3]/div[1]/div/div[17]/button/i";
    String AsignToAssessorXpath = "//*[@id=\"tab-claimEvents\"]/div/div/div[3]/div[1]/div/div[17]/ul/li[8]/a";

    String AssessorXpath = "//*[@id=\"user-selector\"]/table/tbody/tr[51]/td[1]";

    String AddBtnXapth = "(//button)[70]";


    @Step("Click on details ")
    public void Details() throws InterruptedException {
        Thread.sleep(2000);
        $(By.xpath(DetailsXpath)).click();


    }

    @Step("Click on the policies tab")
    public void PolicyTab() throws InterruptedException {
        Thread.sleep(3000);
        $(By.xpath(PolicyTabXpath)).click();

    }


    @Step("Click on the active Policy of choice ")
    public void ActivePolicy() throws InterruptedException {
        Thread.sleep(4000);
        $(By.xpath(ActivePolicyXpath)).click();

    }

    @Step("Click on Policy Individual to make sure of the insured Life ")
    public void PolicyIndividualTab() throws InterruptedException {
        Thread.sleep(3000);
        $(By.xpath(PolicyIndividualXpath)).click();

    }

    @Step("Click on the Intimate Claim button")
    public void IntimateClaimBtn() {
        $(By.xpath(IntimateClaimBtnXpath)).click();

    }


    @Step("Select informationMethod")
    public void SelectInformationMethod(String textDropdown) {
        WebElement dropdown = $(By.xpath(SelectInformationMethodXpath));
        Select selectObject = new Select(dropdown);

        selectObject.selectByVisibleText(textDropdown);

    }

    @Step("Select Claimant")
    public void selectClaim(String textDropdown) {
        WebElement claimant = $(By.xpath(SelectClaimantXpath));
        Select selectObject = new Select(claimant);

        selectObject.selectByVisibleText(textDropdown);

    }

    @Step("Select Relationship")
    public void selectRelationship(String textDropdown) {
        WebElement relationship = $(By.xpath(SelectRelationshipXpath));
        Select selectObject = new Select(relationship);

        selectObject.selectByVisibleText(textDropdown);

    }

    @Step("Select insured life")
    public void selectInsuredLife(String textDropdown) throws InterruptedException {


        WebElement InsuredLife = $(By.xpath(SelectInsuredLifeXpath));
        Select selectObject = new Select(InsuredLife);
        selectObject.selectByVisibleText(textDropdown);

    }

    @Step("Select the Claim type")
    public void ClaimType() throws InterruptedException {
        Thread.sleep(2000);
        $(By.xpath(ClaimTypeTabXpath)).click();
    }

    @Step("Click on the reason of death ")
    public void DeathReason() {
        $(By.xpath(TypefDeathXpath)).click();

    }

    @Step("Enter date of  death")
    public void DateOfDeath(String DoD) {

        WebElement dateEvent = $(By.xpath(DateOfDeathXpath));
        dateEvent.click();

        dateEvent.sendKeys(DoD + Keys.ENTER);

    }

    @Step("Click on the intimate button ")
    public void IntimateBtn() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IntimateBtnXpath)));
        element.click();

    }

//    @Step("View Details")
//    public void ViewD() throws InterruptedException {
//        Thread.sleep(3000);
//        $(By.xpath(ClaimGroupDetailsXpath)).click();


    @Step("Add a new claimant")
    public void newClaimant() throws InterruptedException {
        Thread.sleep(3000);
        $(By.xpath(AddNewClaimantXpath)).click();

    }
    @Step("Enter Name on field text")
    public void enterFirstName(String FirstName){
        WebElement fieldText = $(By.xpath(FirstNameXpath));
        fieldText.click();
        fieldText.sendKeys(FirstName);

    }
    @Step("Enter Name on field text")
    public void enterSurname(String Surname) {
        WebElement fieldText = $(By.xpath(SurnameXpath));
        fieldText.click();
        fieldText.sendKeys(Surname);

    }
    @Step("Select the claimant title ")
    public void selectTittle(String tittle) throws InterruptedException {
        Thread.sleep(3000);

        WebElement dropdown = $(By.xpath(CTitleXpath));
        Select selectObject = new Select(dropdown);
        selectObject.selectByVisibleText(tittle);

    }
    @Step("Enter the claimant ID ")
    public  void  enterClaimantID  (String ID){
        WebElement fieldText = $(By.xpath(CIdNumberXpath));
        fieldText.click();
        fieldText.sendKeys(ID);

    }
    @Step("Enter Claimant Cell number")
    public  void enterClaimantCellNo (String CCellNo){
        WebElement fieldText = $(By.xpath(CCellNumberXpath));
        fieldText.click();
        fieldText.sendKeys(CCellNo);

    }

    @Step("Capture a claimant email address")
    public void CEmailAddressXpath (String CEmail){
        WebElement fieldText = $(By.xpath(CEmailAddressXpath));
        fieldText.click();
        fieldText.sendKeys(CEmail);

    }
    @Step("Click on create claimnt")
    public void CreateC (){
        $(By.xpath(CreateClaimantXpath)).click();

    }

    @Step("Open Life Claims usermanagement")
    public void NavigateToWebsite() throws InterruptedException {
        getDriver().get(UsermanagementURLXpath);
        getDriver().manage().window().maximize();
        Thread.sleep(3000);

    }

    @Step("Click on the user of your choice ")
    public void UserC() throws InterruptedException {
        Thread.sleep(2000);
        $(By.xpath(FindUserXpath)).click();

    }


    @Step("Click on the update user details button")
    public void UserB() {
        $(By.xpath(UpdateUserDetailsXpath)).click();
    }

    @Step("Select a user role")
    public void UserRole(String UserR) throws InterruptedException {
        Thread.sleep(2000);
        WebElement Ur = $(By.xpath(UserRoleXpath));
        selectFromDropdown(Ur, UserR);
    }

    @FindBy(id = "WorkPools")
    private WebElement WorkPools;


    @Step("Highlight Work Pools")
    public void highlightDropDown() {
        Select select = new Select(WorkPools);

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        List<Integer> customIndices = Arrays.asList(4, 9, 2, 10, 7, 6, 5, 1, 8, 3);

        for (int customIndex : customIndices) {
            if (customIndex != 11 ){
                select.selectByIndex(customIndex );

                WebElement selectedOption = select.getFirstSelectedOption();
                js.executeScript("arguments[0].style.backgroundColor = 'yellow';", selectedOption);

            }
        }


    }
    @Step("Click the save button")
    public void SaveBtn (){
        $(By.xpath(SaveBtnXpath)).click();

    }



    @Step("Navigate back")
    public void NavigateBack () throws InterruptedException{
        Thread.sleep(3000);
        getDriver().navigate().to("http://claimstest.clientele.local/ClaimGroup/ClaimGroupIndex?claimGroupId=5ae57b79-f528-c41f-e191-08db1be680e1");
        getDriver().navigate().refresh();

    }

    @Step("Click on the burger menu")
    public void ABurgerMenu (){
        $(By.xpath(ABurgerMenuXpath)).click();

    }


    @Step("Click on assign to assessor")
    public void AssignAssessor (){
        $(By.xpath(AsignToAssessorXpath)).click();

    }


    @Step("Click on the assessor of your choice")
    public void AssessorC (){
        $(By.xpath(AssessorXpath)).click();

    }


    @Step("Click on the add on button")
    public void AddBTN (){
        $(By.xpath(AddBtnXapth)).click();

    }


}
