package pages;

import basePages.AbstractBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ManagerOpenAccountPage extends AbstractBasePage {


    public ManagerOpenAccountPage(WebDriver driver) {
        super(driver);
    }

    private final static String SELECT_CUSTOMER = "//select[@name='userSelect']";
    private final static String CUSTOMER_SELECT = "//select[@name='userSelect']/option[@value='%s']";
    private final static String SELECT_CURRENCY = "//select[@name='currency']";
    private final static String CURRENCY_SELECT = "//select[@name='currency']/option[@value='%s']";
    private final static String PROGRESS_BUTTON = "//button[text()='Process']";

    @Override
    public ManagerOpenAccountPage open() {
        openUrl(env);
        return this;
    }

    public WebElement selectCustomer() {
        return waitVisibleOfElement(SELECT_CUSTOMER);
    }

    public WebElement selectCurrency() {
        return waitVisibleOfElement(SELECT_CURRENCY);
    }

    public WebElement Customer(int customerName) {
        return waitClickableElementByXpath(String.format(CUSTOMER_SELECT, customerName));
    }

    public WebElement Currency(String currency) {
        return waitClickableElementByXpath(String.format(CURRENCY_SELECT, currency));
    }

    public WebElement progressBtn() {
        return waitClickableElementByXpath(PROGRESS_BUTTON);
    }

    //HELP METHODS

    public ManagerOpenAccountPage selectCustomerName(int customerName) {
        Customer(customerName).click();
        return this;

    }

    public ManagerOpenAccountPage selectCurrency(String currency) {
        Currency(currency).click();
        return this;

    }

    public ManagerOpenAccountPage clickProgressBtn() {
        progressBtn().click();
        return this;

    }

    public ManagerOpenAccountPage goToManagerOpenAccountPage() {
        HomePage homePage = new HomePage(driver);
        homePage
                .open()
                .clickBtnBankManagerLogin()
                .clickOpenAccountsBtn();
        return new ManagerOpenAccountPage(driver);

    }

    public String getAlertMessagePrint() {
        return driver.switchTo().alert().getText().split(":")[1];
    }

}