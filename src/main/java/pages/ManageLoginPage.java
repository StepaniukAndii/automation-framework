package pages;

import basePages.AbstractBasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ManageLoginPage extends AbstractBasePage {

    protected ManageLoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ManageLoginPage open() {
        openUrl(env + "manager");
        return this;
    }

    public WebElement getAddCustomerBtn() {
        return waitClickableElementByXpath("//button[@ng-click='addCust()']");
    }

    @Step("Click add customer button")
    public ManagerAddCustomerPage clickAddCustomerBtn() {
        getAddCustomerBtn().click();
        return new ManagerAddCustomerPage(driver);
    }
}

