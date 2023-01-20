package PageObject;

import BasePages.AbstractBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends AbstractBasePage {

    public HomePage(WebDriver driver) {

        super(driver);
    }
    @Override
    public HomePage open() {
        openUrl(env + "login");
        return this;
    }

    public WebElement getCustomerLoginBtn() {
        return waitClickableElementByXpath("//button[contains(text(),'Customer Login')]");
    }

    public WebElement getBankManagerLoginBtn() {
        return waitClickableElementByXpath("//button[contains(text(),'Bank Manager Login')]");
    }

    public ManagerLoginPage clickBankManagerLoginBtn() {
        getBankManagerLoginBtn().click();
        return new ManagerLoginPage(driver);
    }

    public CustomerLoginPage clickCustomerLoginBtn() {
        getCustomerLoginBtn().click();
        return new CustomerLoginPage(driver);
    }
}
