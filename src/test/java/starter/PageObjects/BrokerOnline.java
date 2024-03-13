package starter.PageObjects;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BrokerOnline extends PageObject {

    String Url = "https://cbc-uat.clientele.co.za/BrokerOnline/Login";

    String AccessCodeXpath = "(//input[@id='b1-Input_AccessCode'])[1]";

    String ConfirmBtnXpath = "//span[normalize-space()='Confirm']";

    String BrokerCodeXpath = "//input[@id='Input_UsernameVal']";

    String PasswordXpath = "//input[@id='Input_PasswordVal']";

    String LoginBtnXpath = "//button[@type='submit']";

    String NewSaleXpath = "(//button[normalize-space()='New Sale'])[1]";

    String SelectProductXpath = "//*[@id=\"b3-BrokerProducts\"]";

    String AppNumberXpath = "(//input[@id='b3-ApplicationNumberInput'])[1]";

    String ContinueBtnXpath = "//button[normalize-space()='Continue']";

    String CompanyNameXpath = "//*[@id=\"b42-Input_CompanyName\"]";

    String BusinessTypeXpath = "//*[@id=\"b42-Dropdown_EntityType\"]";

    String NumberOfEmpXpath = "//*[@id=\"b42-Input_NumberOfEmployees\"]";

    String MobileNumXpath = "//*[@id=\"b42-Input_MobileTelephoneNumber\"]";

    String WorkNumXpath = "//*[@id=\"b42-Input_WorkTelephoneNumber\"]";

    String AnnualTurnOverXpath = "//*[@id=\"b42-AnnualTurnover\"]";

    String PhyAddL1Xpath = "//*[@id=\"b42-Input_ResidentialAddressLine1\"]";

    String PhyAddL2Xpath = "//*[@id=\"b42-Input_ResidentialAddressLine2\"]";

    String PhyAddCodeXpath = "//*[@id=\"b42-Input_ResidentialAddressCode\"]";

    String PoAddL1Xpath = "//*[@id=\"b42-Input_PostalAddressLine1\"]";

    String PoAddCodeXpath = "//*[@id=\"b42-Input_PostalAddressCode\"]";

    String AddressCopyXpath = "(//input[@id='b42-AddressCopy'])[1]";

    String SameAsContactPersonXpath = "//*[@id=\"b48-SameAsContactPerson\"]";

    String SameAsRegBusinessXpath = "//*[@id=\"b50-SameAsRegBusiness\"]";


    @Step("Open Broker Online Website")
    public void OpenWebsite() throws InterruptedException {
        getDriver().manage().window().maximize();
        getDriver().get(Url);
        Thread.sleep(3000);
    }

    @Step("Enters Access Code and Confirm")
    public void enterCode(String code) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(4));

        WebElement accessCode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(AccessCodeXpath)));

        accessCode.sendKeys(code);


        $(By.xpath(ConfirmBtnXpath)).click();

    }

    @Step("Enters Broker Code")
    public void brokerCode(String BCode) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(4));

        WebElement brokerCode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BrokerCodeXpath)));

        brokerCode.sendKeys(BCode);

    }

    @Step("Enter Password and Login")
    public void password(String PassWord) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(4));

        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PasswordXpath)));

        password.sendKeys(PassWord);

        $(By.xpath(LoginBtnXpath)).click();

    }

    @Step("Click on NewSale button")
    public void newSale() throws InterruptedException {
        Thread.sleep(10000);
        $(By.xpath(NewSaleXpath)).click();

    }

    @Step("Select Broker Products")
    public void selectProduct(String Products) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SelectProductXpath)));
        Select selectObject = new Select(dropdown);

        selectObject.selectByVisibleText(Products);

    }

    @Step("Click on Continue button")
    public void continueBtn() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(4));

        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ContinueBtnXpath)));

        button.click();

    }

    @Step("Enter Company Name")
    public void companyName(String text) throws InterruptedException {
        Thread.sleep(10000);
        $(By.id("b42-Input_CompanyName")).getText();
        $(By.id("b42-Input_CompanyName")).sendKeys(text);

    }

    @Step("Select Business Type from dropdown list")
    public void businessType(String Business) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(4));
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BusinessTypeXpath)));
        Select selectObject = new Select(dropdown);

        selectObject.selectByVisibleText(Business);

    }

    @FindBy(xpath = "//*[@id=\"b42-IDPassportNumber\"]")
    private WebElement idNumber;

    @FindBy(xpath = "//*[@id=\"b42-Input_RegistrationNumber\"]")
    private WebElement registrationNum;

    @Step("Enter Registration, ID or Passport Number")
    public void textNum(String number) {
        if (isIdNumberVisible()) {
            idNumber.sendKeys(number);
        } else if (isRegistrationNumVisible()) {
            registrationNum.sendKeys(number);
        } else {
            System.out.println("Neither ID number nor Registration is visible ");
        }


    }

    private boolean isIdNumberVisible() {
        return idNumber.isDisplayed();
    }


    private boolean isRegistrationNumVisible() {
        return registrationNum.isDisplayed();

    }

    @Step("Enter number of employees")
    public void employeeNum(String numOfEmp) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(4));

        WebElement textField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(NumberOfEmpXpath)));

        textField.sendKeys(numOfEmp);

    }

    @Step("Enter Mobile number")
    public void mobNumb(String mobile) {
        $(By.xpath(MobileNumXpath)).sendKeys(mobile);

    }

    @Step("Enter Work Number")
    public void workNum(String workNumber) {
        $(By.xpath(WorkNumXpath)).sendKeys(workNumber);

    }

    @Step("Select AnnualTurnOver from dropdown list")
    public void annualTurnOver(String amount) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(4));
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(AnnualTurnOverXpath)));
        Select selectObject = new Select(dropdown);

        selectObject.selectByVisibleText(amount);


    }

    @Step("Enter Physical address Line1, Line2 and code")
    public void address(String line1, String line2, String code) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        $(By.xpath(PhyAddL1Xpath)).sendKeys(line1);

        $(By.xpath(PhyAddL2Xpath)).sendKeys(line2);

        $(By.xpath(PhyAddCodeXpath)).sendKeys(code);

        WebElement checkbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(AddressCopyXpath)));
        checkbox.click();

        $(By.xpath(ContinueBtnXpath)).click();
        Thread.sleep(10000);

    }

    @Step("Select Underwriting Questionnaires ")
    public void underWriting(String legalMatters, String legalEntity, String overDueInvoices, String industry, String industrySpecifics) throws InterruptedException {
        Thread.sleep(10000);
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(4));

        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"b44-LegalMatters\"]")));
        Select selectObject = new Select(dropdown);

        selectObject.selectByVisibleText(legalMatters);

        WebElement dropdown1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"b44-IsLegalEntity\"]")));
        Select selectObject1 = new Select(dropdown1);

        selectObject1.selectByVisibleText(legalEntity);

        WebElement dropdown2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"b44-Invoices\"]")));
        Select selectObject2 = new Select(dropdown2);

        selectObject2.selectByVisibleText(overDueInvoices);

        WebElement dropdown3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"b44-Industry\"]")));
        Select selectObject3 = new Select(dropdown3);

        selectObject3.selectByVisibleText(industry);

        $(By.xpath("//*[@id=\"b44-TextArea_IndustrySpecifics\"]")).sendKeys(industrySpecifics);

        Thread.sleep(10000);

        $(By.xpath(ContinueBtnXpath)).click();

    }

    @Step("Fill in Contact Person details form")
    public void detailsForm(String tittle, String IdType) {

        $(By.xpath("//*[@id=\"b46-Input_Title\"]")).sendKeys(tittle);

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(4));
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"b46-Dropdown_IdentityType\"]")));

        Select selectObject = new Select(dropdown);

        selectObject.selectByVisibleText(IdType);
    }

    @FindBy(xpath = "//*[@id=\"b46-Input_PassportNumber\"]")
    private WebElement passport;

    @FindBy(xpath = "//*[@id=\"b46-Input_IdentityNumber\"]")
    private WebElement Identity;

    @Step("Enter ID or Passport number")
    public void iDPassNumber(String IDPassNumb) {

        if(isIdNumbVisible())

    {
        $(By.xpath("//*[@id=\"b46-Input_PassportNumber\"]")).sendKeys(IDPassNumb);
    } else if(isPassNumVisible())

    {
        $(By.xpath("//*[@id=\"b46-Input_IdentityNumber\"]")).sendKeys(IDPassNumb);
    } else

    {
        System.out.println("Neither ID number nor Passport is visible ");
    }

}




    private boolean isIdNumbVisible() {
        return passport.isDisplayed();
    }


    private boolean isPassNumVisible() {
        return Identity.isDisplayed();

    }

   @Step("Fill in Contact Person details form")
    public void completeForm(String firstNames, String surName, String mobileNumber, String jobPosition, String isPrimaryContact ) throws InterruptedException {
        $(By.xpath("//*[@id=\"b46-Input_FirstNames\"]")).sendKeys(firstNames);

       $(By.xpath("//*[@id=\"b46-Input_Surname\"]")).sendKeys(surName);

       $(By.xpath("//*[@id=\"b46-Input_MobileTelephoneNumber\"]")).sendKeys(mobileNumber);

       WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(4));
       WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"b46-Input_JobPosition\"]")));

       Select selectObject = new Select(dropdown);

       selectObject.selectByVisibleText(jobPosition);


       WebElement dropdown1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"b46-Input_IsPrimaryContact\"]")));

       Select selectObject1 = new Select(dropdown1);

       selectObject1.selectByVisibleText(isPrimaryContact);

       Thread.sleep(10000);

       $(By.xpath(ContinueBtnXpath)).click();

   }

   @Step("Enter Mandate Holder details")
    public void sameAsContactPerson(){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        WebElement checkBox = $(By.xpath(SameAsContactPersonXpath));
        checkBox.click();

   }

   @Step("Enter Payer Details")
    public void sameAsRegBusiness(String jobPosition, String tittle, String IdentityType){
       WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

       WebElement checkBox = $(By.xpath(SameAsRegBusinessXpath));
       checkBox.click();

       WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"b50-Dropdown_JobPosition\"]")));

       Select selectObject = new Select(dropdown);

       selectObject.selectByVisibleText(jobPosition);

       WebElement dropdown1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"b50-Dropdown_Title\"]")));

       Select selectObject1 = new Select(dropdown1);

       selectObject1.selectByVisibleText(tittle);

       WebElement dropdown2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"b50-Dropdown_IdentityType\"]")));

       Select selectObject2 = new Select(dropdown2);

       selectObject2.selectByVisibleText(IdentityType);

   }

    @FindBy(xpath = "//*[@id=\"b46-Input_PassportNumber\"]")
    private WebElement passportNum;

    @FindBy(xpath = "//*[@id=\"b46-Input_IdentityNumber\"]")
    private WebElement IdentityNum;

    @Step("Enter ID or Passport number")
    public void iDPassNumb(String IDPassNumb) {

        if(isIdVisible())

        {
            $(By.xpath("//*[@id=\"b50-Input_PassportNumber\"]")).sendKeys(IDPassNumb);
        } else if(isPassNumbVisible())

        {
            $(By.xpath("//*[@id=\"b50-Input_IdentityNumber\"]")).sendKeys(IDPassNumb);
        } else

        {
            System.out.println("Neither ID number nor Passport is visible ");
        }

    }




    private boolean isIdVisible() {
        return passport.isDisplayed();
    }


    private boolean isPassNumbVisible() {
        return Identity.isDisplayed();

    }

    @Step("Continue with Payer Details")
    public void payerDetails(String fistName, String surName, String mobileNum, String workNum,String bankName, String bankAccType, String bankAccNum, String pointOFSaleVerified, String debitDay){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        $(By.xpath("//*[@id=\"b50-Input_FirstNames\"]")).sendKeys(fistName);

        $(By.xpath("//*[@id=\"b50-Input_Surname\"]")).sendKeys(surName);

        $(By.xpath("//*[@id=\"b50-Input_MobileTelephoneNumber\"]")).sendKeys(mobileNum);

        $(By.xpath("//*[@id=\"b50-Input_WorkTelephoneNumber\"]")).sendKeys(workNum);

        WebElement dropdown1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"b50-Dropdown_BankName\"]")));

        Select selectObject1 = new Select(dropdown1);

        selectObject1.selectByVisibleText(bankName);

        WebElement dropdown2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"b50-Dropdown_BankAccountType\"]")));

        Select selectObject2 = new Select(dropdown2);

        selectObject2.selectByVisibleText(bankAccType);

        $(By.xpath("//*[@id=\"b50-Input_BankAccountNumber\"]")).sendKeys(bankAccNum);

        WebElement dropdown3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"b50-Dropdown_POS\"]")));

        Select selectObject3 = new Select(dropdown3);

        selectObject3.selectByVisibleText(pointOFSaleVerified);

        $(By.xpath("(//input[@id='b50-Checkbox1'])[1]")).click();

        WebElement dropdown4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"b50-Dropdown_DebitDay2\"]")));

        Select selectObject4 = new Select(dropdown4);

        selectObject4.selectByVisibleText(pointOFSaleVerified);

        $(By.xpath(ContinueBtnXpath)).click();

    }

    @Step("Confirm Sale confirmation")
    public void saleConfirmation(){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        WebElement checkBox = $(By.xpath("(//input[@id='b51-Checkbox2'])[1]"));

        checkBox.click();



    }



}



