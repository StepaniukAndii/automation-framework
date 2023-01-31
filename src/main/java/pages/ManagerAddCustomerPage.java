package pages;

import basePages.AbstractBasePage;
import elements.HeaderElements;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
@Log4j
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

    public ManageLoginPage enterRegistrationCredits(String firstName, String lastName, String postCode) {
        getFirstNameField().sendKeys(firstName);
        getLastName().sendKeys(lastName);
        getPostCode().sendKeys(postCode);
        addCustomerSubmit().click();
        alertMessageClose();
        return new ManageLoginPage(driver);
    }

    public ManageLoginPage alertMessageClose(){
        log.info("---------------------Close alert message---------------------");
        driver.switchTo().alert().accept();
        return new ManageLoginPage(driver);

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
