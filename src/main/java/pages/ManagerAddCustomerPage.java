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
        openUrl(env + "manager/addCust");
        return this;
    }

    public HeaderElements getHeaderElements() {
        return new HeaderElements(driver);
    }

    public ManagerAddCustomerPage enterRegistrationCredits(String firstName, String lastName, String postCode) {
        getFirstNameField().sendKeys(firstName);
        getLastName().sendKeys(lastName);
        getPostCode().sendKeys(postCode);
        addCustomerSubmit().click();
        return this;
    }

    public WebElement getFirstNameField() {
        return waitClickableElementByXpath("//input[@placeholder = \"First Name\"]");
    }

    public WebElement getLastName() {
        return waitClickableElementByXpath("//input[@placeholder = \"Last Name\"]");
    }

    public WebElement getPostCode() {
        return waitClickableElementByXpath("//input[@placeholder = \"Post Code\"]");
    }

    public WebElement addCustomerSubmit() {
        return waitClickableElementByXpath("//button[@type = \"submit\"]");
    }
}
