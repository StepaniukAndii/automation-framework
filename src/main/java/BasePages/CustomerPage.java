package BasePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomerPage extends AbstractBasePage {

    protected CustomerPage(WebDriver driver) {
        super(driver);
    }
    
    public WebElement TransactionButton() {
        return $x("//button[@ng-class='btnClass1']");
    }
    public WebElement DepositButton() {
        return $x("//button[@ng-class='btnClass2']");
    }
    public WebElement WithdrawButton() {
        return $x("//button[@ng-class='btnClass3']");
    }
    public WebElement LogoutButton() {
        return $x("//button[@class='logout']");
    }
    public WebElement Name(String name) {
        return $x("//span[text()='" + name + "']");
    }
    public WebElement AccountNumber(String value) {
        return $x("//strong[text()='" + value + "']");
    }
    public WebElement AccountBalance(String value) {
        return $x("//strong[text()='" + value + "']");
    }
    public WebElement AccountCurrency(String value) {
        return $x("//strong[text()='" + value + "']");
    }
    public WebElement AccountSelectField() {
        return $x("//select[@id='accountSelect']");
    }
}
