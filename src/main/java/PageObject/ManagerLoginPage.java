package PageObject;

import BasePages.AbstractBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ManagerLoginPage extends AbstractBasePage {
    protected ManagerLoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ManagerLoginPage open() {
        openUrl(env);
        return this;
    }

    public WebElement addCustomerPage(){
        return waitClickableElementByXpath("//button[@ng-class='btnClass1']");
    }

}
