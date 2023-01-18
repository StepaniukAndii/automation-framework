package Pages;

import elements.CustomerPageElements;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomerLoginPage extends CustomerPageElements {

    public CustomerLoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@ng-click='customer()']")
    private WebElement customerBtn;

    @Override
    public CustomerLoginPage open() {
        openUrl("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/customer");
        return this;
    }

    @Step("Click on 'HOME' button")
    public CustomerLoginPage clickHomeBtn() {
        getHomeBtn().click();
        return this;
    }

    @Step("Sellect UserOne")
    public CustomerLoginPage clickUserOne() {
        getUserOne().click();
        return this;
    }

    @Step("Sellect UserTwo")
    public CustomerLoginPage clickUserTwo() {
        getUserTwo().click();
        return this;
    }

    @Step("Sellect UserThree")
    public CustomerLoginPage clickUserThree() {
        getUserThree().click();
        return this;
    }

    @Step("Sellect UserFour")
    public CustomerLoginPage clickUserFour() {
        getUserFour().click();
        return this;
    }

    @Step("Sellect User")
    public CustomerLoginPage clickUserFive() {
        getUserFive().click();
        return this;
    }

    @Step("Click on 'LOGIN' Btn")
    public CustomerLoginPage clickLoginBtn() {
        getLoginBtn().click();
        return this;
    }


}
