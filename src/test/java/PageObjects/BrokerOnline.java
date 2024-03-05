package PageObjects;

import net.serenitybdd.annotations.Step;
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

    String SelectProductXpath = "(//select[@id='b3-BrokerProducts'])[1]";

    String AppNumberXpath = "(//input[@id='b3-ApplicationNumberInput'])[1]";

    String ContinueBtnXpath = "//button[normalize-space()='Continue']";

    @Step("Open Broker Online Website")
    public void OpenWebsite() throws InterruptedException {
        getDriver().manage().window().maximize();
        getDriver().get(Url);
        Thread.sleep(3000);
    }

    @Step("Enters Access Code and Confirm")
    public void enterCode(String code){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(4));

        WebElement accessCode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(AccessCodeXpath)));

        accessCode.sendKeys(code);


        $(By.xpath(ConfirmBtnXpath)).click();

    }

    @Step("Enters Broker Code")
    public void brokerCode(String BCode){
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
        Thread.sleep(5000);
        $(By.xpath(NewSaleXpath)).click();

    }

    @Step("Select Broker Products")
    public void selectProduct(String Products){
        WebElement dropdown = $(By.xpath(SelectProductXpath));
        Select selectObject = new Select(dropdown);

        selectObject.selectByValue(Products);

    }

    @Step("Enter Application Number")
    public void appNumber(String ApplicationNum){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(4));

        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(AppNumberXpath)));

        password.sendKeys(ApplicationNum);

        $(By.xpath(ContinueBtnXpath)).click();
    }


}
