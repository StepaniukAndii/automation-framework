package elements;

import BasePages.AbstractBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomerCabinetElements extends AbstractBasePage {

    public CustomerCabinetElements(WebDriver driver) {
        super(driver);
    }

    private static final String CREDENTIALS_IN_CABINET = "//span[@class = 'fontBig ng-binding']";

    public WebElement getCredentialsInCabinet() {
        return waitVisibleOfElement(CREDENTIALS_IN_CABINET);
    }

    @Override
    public CustomerCabinetElements open() {
        openUrl("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/account");
        return this;
    }
}
