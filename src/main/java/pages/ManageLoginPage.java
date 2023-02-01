package pages;

import basePages.AbstractBasePage;
import elements.HeaderElements;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ManageLoginPage extends AbstractBasePage {

    public HeaderElements headerElements;

    public ManageLoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ManageLoginPage open() {
        openUrl(env + "manager");
        headerElements = new HeaderElements(driver);
        return this;
    }

    public HeaderElements getHeaderElements() {
        if (headerElements == null) {
            return headerElements = new HeaderElements(driver);
        } else {
            return headerElements;
        }
    }


    public WebElement getAddCustomerBtn() {
        return waitClickableElementByXpath("//button[@ng-click='addCust()']");
    }

    public WebElement getManagerOpenAccountBtn() {
        return waitClickableElementByXpath("//button[@ng-click='openAccount()']");
    }

    public WebElement getManagerCustomerBtn() {
        return waitClickableElementByXpath("//button[@ng-click='showCust()']");
    }

    @Step("Click add customer button")
    public ManagerAddCustomerPage clickAddCustomerBtn() {
        getAddCustomerBtn().click();
        return new ManagerAddCustomerPage(driver);
    }

    @Step("Click manager open account page")
    public ManagerOpenAccountPage clickOpenAccountBtn() {
        getManagerOpenAccountBtn().click();
        return new ManagerOpenAccountPage(driver);
    }

    @Step("Click Home Button Page")
    public HomePage clickHomeBtn() {
        getHeaderElements();
        headerElements.clickHomeBtn();
        return new HomePage(driver);
    }

    @Step("Click openCustomerPage")
    public ManagerCustomersPage clickOpenCustomerPage() {
        getManagerCustomerBtn().click();
        return new ManagerCustomersPage(driver);
    }
}

