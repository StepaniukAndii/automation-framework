package pages;

import basePages.AbstractBasePage;
import elements.HeaderElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ManagerAddCustomerPage extends AbstractBasePage {

    public ManagerAddCustomerPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ManagerAddCustomerPage open() {
        openUrl(envmanager);
        return this;
    }

    public HeaderElements getHeaderElements() {
        return new HeaderElements(driver);
    }

    public ManagerAddCustomerPage enterRegistrationCredits(String firstName, String lastName, String postCode) {
        getFirstNameField().sendKeys(firstName);
        getLastName().sendKeys(lastName);
        getPostCode().sendKeys(postCode);
        return this;
    }

    public WebElement addCustomerBtn() {
        return waitClickableElementByXpath("//button[@ng-click = \"addCust()\"]");
    }
    public ManagerAddCustomerPage clickAddCustomerBtn() {
        addCustomerBtn().click();
        return this;
    }

    public WebElement getFirstNameField() {
        return waitClickableElementByXpath("//input[@placeholder = \"First Name\"]");
    }
    public ManagerAddCustomerPage clickFirstName() {
        getFirstNameField().click();
        return this;
    }

    public WebElement getLastName() {
        return waitClickableElementByXpath("//input[@placeholder = \"Last Name\"]");
    }
    public ManagerAddCustomerPage clickLastName() {
        getLastName().click();
        return this;
    }

    public WebElement getPostCode() {
        return waitClickableElementByXpath("//input[@placeholder = \"Post Code\"]");
    }
    public ManagerAddCustomerPage clickPostCode() {
        getPostCode().click();
        return this;
    }

    public WebElement addCustomerSubmit() {
        return waitClickableElementByXpath("//button[@type = \"submit\"]");
    }
    public ManagerAddCustomerPage clickAddCustSubmit() {
        addCustomerSubmit().click();
        return this;
    }
}
