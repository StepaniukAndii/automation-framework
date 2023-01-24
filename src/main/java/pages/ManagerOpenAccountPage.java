package pages;

import basePages.AbstractBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ManagerOpenAccountPage extends AbstractBasePage {


    public ManagerOpenAccountPage(WebDriver driver) {
        super(driver);
    }

    private final static String SELECT_CUSTOMER = "//select[@name='userSelect']";
    private final static String SELECT_CURRENCY = "//select[@name='currency']";
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
        return waitClickableElementByXpath("//option[@value='" + customerName + "']");
    }

    public WebElement Currency(String currency) {
        return waitClickableElementByXpath("//option[@value='" + currency + "']");
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

    public void alertMessagePrint() {
        String alertMessage = driver.switchTo().alert().getText();
        String[] splitted = alertMessage.split(":");
        String account = splitted[1];
        System.out.println(account);
    }

}