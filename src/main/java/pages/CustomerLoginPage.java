package pages;

import basePages.AbstractBasePage;
import elements.HeaderElements;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CustomerLoginPage extends AbstractBasePage {

    private HeaderElements headerElements;

    public CustomerLoginPage(WebDriver driver) {
        super(driver);
    }

    public HeaderElements getHeaderElements() {
        if (headerElements == null) {
           return headerElements = new HeaderElements(driver);
        } else {
            return headerElements;
        }
    }

    @Override
    public CustomerLoginPage open() {
        openUrl(env + "customer");
        return this;
    }

    private final static String USER_SELECT = "//select[@name='userSelect']";
    private final static String CUSTOMER_LOGIN_BUTTON = "//button[text()='Login']";

    public WebElement loginBtn() {
        return waitClickableElementByXpath(CUSTOMER_LOGIN_BUTTON);
    }

    @Step("Select user {0}")
    public CustomerLoginPage selectUser(String customer) {
        new Select(waitVisibleOfElement(USER_SELECT)).selectByVisibleText(customer);
        return this;
    }

    @Step("Click on 'LOGIN' Btn")
    public CustomerPage clickLoginBtn() {
        loginBtn().click();
        return new CustomerPage(driver);
    }
}
