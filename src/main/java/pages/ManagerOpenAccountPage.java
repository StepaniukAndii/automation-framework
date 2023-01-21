package pages;

import basePages.AbstractBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ManagerOpenAccountPage extends AbstractBasePage {

    public ManagerOpenAccountPage(WebDriver driver) {
        super(driver);
    }

    private final static String PROGRESS_BUTTON = "//button[text()='Process']";

    @Override
    public ManagerOpenAccountPage open() {
        openUrl(env);
        return this;
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

    public void alertMessagePrint() {
        String alertMessage = driver.switchTo().alert().getText();
        String[] splitted = alertMessage.split(":");
        String account = splitted[1];
        System.out.println(account);
    }

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

}