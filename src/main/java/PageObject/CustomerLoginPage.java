package PageObject;

import BasePages.AbstractBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomerLoginPage extends AbstractBasePage {
    protected CustomerLoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public CustomerLoginPage open() {
        openUrl(env);
        return this;
    }

    public WebElement select(){
        return waitClickableElementByXpath("//*[@id='userSelect']");
    }
}
