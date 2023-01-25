package pages;

import basePages.AbstractBasePage;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
@Log4j
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

    public ManageLoginPage clickBankManagerLoginBtn() {
        log.info("====================Use clickBankManagerLoginBtn====================");
        getBankManagerLoginBtn().click();
        return new ManageLoginPage(driver);
    }

    public CustomerLoginPage clickCustomerLoginBtn() {
        log.info("====================Use clickCustomerLoginBt====================");
        getCustomerLoginBtn().click();
        return new CustomerLoginPage(driver);
    }
}
