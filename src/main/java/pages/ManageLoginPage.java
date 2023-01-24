package pages;

import basePages.AbstractBasePage;
import elements.HeaderElements;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ManageLoginPage extends AbstractBasePage {

    public HeaderElements headerElements;

    protected ManageLoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ManageLoginPage open() {
        openUrl(env + "manager");
        headerElements = new HeaderElements(driver);
        return this;
    }

    public WebElement getAddCustomerBtn() {
        return waitClickableElementByXpath("//button[@ng-click='addCust()']");
    }

    public WebElement getManagerOpenAccountBtn() {
        return waitClickableElementByXpath("//button[@ng-click='openAccount()']");

    }

    public WebElement getManagerCustomerBtn(){
        return waitClickableElementByXpath("//button[@ng-click='showCust()']");
    }



    @Step("Click add customer button")
    public ManagerAddCustomerPage clickAddCustomerBtn() {
        getAddCustomerBtn().click();
        return new ManagerAddCustomerPage(driver);
    }

    public ManagerOpenAccountPage clickOpenAccountBtn() {
        getManagerOpenAccountBtn().click();
        return new ManagerOpenAccountPage(driver);
    }

  public HomePage clickHomeBtn(){
        headerElements.getHomeBtn().click();
        return new HomePage(driver);
  }
}

