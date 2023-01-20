package pages;

import org.openqa.selenium.WebDriver;

import elements.CustomerPageElements;

public class CustomerPage extends CustomerPageElements {

    protected CustomerPage(WebDriver driver) {
        super(driver);
    }
    public CustomerPage clickTransactionButton() {
        transactionButton().click();
        return this;
    }
    public CustomerPage clickDepositButton() {
        depositButton().click();
        return this;
    }
    public CustomerPage clickWithdrawButton() {
        withdrawButton().click();
        return this;
    }
    public CustomerPage clickLogoutButton() {
        logoutButton().click();
        return this;
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
