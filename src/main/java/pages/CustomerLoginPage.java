package pages;

import basePages.AbstractBasePage;
import elements.HeaderElements;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomerLoginPage extends AbstractBasePage {

    public CustomerLoginPage(WebDriver driver) {
        super(driver);
    }

    public HeaderElements getHeaderElements() {
        return new HeaderElements(driver);
    }

    @Override
    public CustomerLoginPage open() {
        openUrl(env + "customer");
        return this;
    }

    private final static String USER_SELECT = "//select[@name='userSelect']";
    private final static String CUSTOMER_LOGIN_BUTTON = "//button[text()='Login']";

    public WebElement user(int customer) {
        return waitClickableElementByXpath("//option[@value='" + customer + "']");
    }

    public WebElement loginBtn() {
        return waitClickableElementByXpath(CUSTOMER_LOGIN_BUTTON);
    }
    public WebElement userSelection(){
        return waitVisibleOfElement(USER_SELECT);
    }

    @Step("Click on 'LOGIN' Btn")
    public CustomerLoginPage clickLoginBtn() {
        loginBtn().click();
        return this;
    }

    public CustomerLoginPage clickUser(int customer) {
        user(customer).click();
        return this;
    }
}
