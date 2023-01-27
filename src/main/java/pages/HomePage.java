package pages;

import basePages.AbstractBasePage;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Log4j
public class HomePage extends AbstractBasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Open login page")
    public HomePage open() {
        log.info("open login page");
        openUrl(env + "login");
        return this;
    }

    public WebElement getCustomerLoginBtn() {
        return waitClickableElementByXpath("//button[contains(text(),'Customer Login')]");
    }

    public WebElement getBankManagerLoginBtn() {
        return waitClickableElementByXpath("//button[contains(text(),'Bank Manager Login')]");
    }

    @Step("Click on  Bank customer login btn")
    public ManageLoginPage clickBankManagerLoginBtn() {
        log.info("click bank customer login btn");
        getBankManagerLoginBtn().click();
        return new ManageLoginPage(driver);
    }

    @Step("Click on CustomerLogin Btn")
    public CustomerLoginPage clickCustomerLoginBtn() {
        log.info("click customer login btn");
        getCustomerLoginBtn().click();
        return new CustomerLoginPage(driver);
    }
}
