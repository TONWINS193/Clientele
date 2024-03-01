package PageObjects;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ClaimsAuthenticateLogin extends PageObject {

    String Url = "http://kmolale:Kebaabetswem@24@claimstest.clientele.local/";

    String txtSearchXpath = "//*[@id=\"txtSearch\"]";

    String btnSearchXpath = "//*[@id=\"btnSearch\"]";

    @Step(" Authenticate website to view Homepage")
    public void OpenWebsite() throws InterruptedException {
        getDriver().manage().window().maximize();
        getDriver().get(Url);
        Thread.sleep(3000);


    }

    @Step("Search policies using any that falls on under search tips")
    public void SearchField(String PolicyNumber){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(txtSearchXpath)));
        element.sendKeys(PolicyNumber);

        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnSearchXpath)));
        button.click();


    }



}
