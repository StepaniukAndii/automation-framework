package pages;

import basePages.AbstractBasePage;
import lombok.SneakyThrows;
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

    @SneakyThrows
    public WebElement getCustomerLoginBtn() {
        Thread.sleep(500);
        return waitClickableElementByXpath("//button[contains(text(),'Customer Login')]");
    }

    public WebElement getBankManagerLoginBtn() {
        return waitClickableElementByXpath("//button[contains(text(),'Bank Manager Login')]");
    }

    public ManageLoginPage clickBankManagerLoginBtn() {
        getBankManagerLoginBtn().click();
        return new ManageLoginPage(driver);
    }

    public CustomerLoginPage clickCustomerLoginBtn() {
        getCustomerLoginBtn().click();
        return new CustomerLoginPage(driver);
    }
}
