package pages;

import org.openqa.selenium.WebDriver;

import basePages.AbstractBasePage;
import elements.CustomerPageElements;

public class CustomerPage extends CustomerPageElements {

    protected CustomerPage(WebDriver driver) {
        super(driver);
    }
    public AbstractBasePage clickTransactionButton() {
        transactionButton().click();
        return new CustomerTransactions(driver);
    }
    public AbstractBasePage clickDepositButton() {
        depositButton().click();
        return new CustomerDepositPage(driver);
    } 
    public AbstractBasePage clickWithdrawButton() {
        withdrawButton().click();
        return new CustomerWithdrawlPage(driver);
    }
    public AbstractBasePage clickLogoutButton() {
        logoutButton().click();
        return new CustomerLoginPage(driver);
    }
    public String getName() {
        return name().getText();
    }
    public String getAccountNumber() {
        return accountNumber().getText();
    }
    public String getAccountBalance() {
        return accountBalance().getText();
    }
    public String getAccountCurrency() {
        return accountCurrency().getText();
    }
    public CustomerPage selectAccount(String accString) {
        accountSelectField().selectByVisibleText(accString);
        return this;
    }
}