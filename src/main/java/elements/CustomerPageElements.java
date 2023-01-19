package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import BasePages.AbstractBasePage;

public class CustomerPageElements extends AbstractBasePage {
    protected CustomerPageElements(WebDriver driver) {
        super(driver);
    }
    
    public WebElement TransactionButton() {
        return waitClickableElementByXpath("//button[@ng-class='btnClass1']");
    }
    public WebElement DepositButton() {
        return waitClickableElementByXpath("//button[@ng-class='btnClass2']");
    }
    public WebElement WithdrawButton() {
        return waitClickableElementByXpath("//button[@ng-class='btnClass3']");
    }
    public WebElement LogoutButton() {
        return waitClickableElementByXpath("//button[@class='logout']");
    }
    public WebElement Name() {
        return waitClickableElementByXpath("/html/body/div/div/div[2]/div/div[1]/strong/span");
    }
    public WebElement AccountNumber() {
        return waitClickableElementByXpath("/html/body/div/div/div[2]/div/div[2]/strong[1]");
    }
    public WebElement AccountBalance() {
        return waitClickableElementByXpath("/html/body/div/div/div[2]/div/div[2]/strong[2]");
    }
    public WebElement AccountCurrency() {
        return waitClickableElementByXpath("/html/body/div/div/div[2]/div/div[2]/strong[3]");
    }
    public WebElement AccountSelectField() {
        return waitClickableElementByXpath("//select[@id='accountSelect']");
    }
}
