package pages;

import org.openqa.selenium.WebDriver;

import elements.CustomerPageElements;

public class CustomerPage extends CustomerPageElements {

    protected CustomerPage(WebDriver driver) {
        super(driver);
    }
    public CustomerPage clickTransactionButton() {
        TransactionButton().click();
        return this;
    }
    public CustomerPage clickDepositButton() {
        DepositButton().click();
        return this;
    }
    public CustomerPage clickWithdrawButton() {
        WithdrawButton().click();
        return this;
    }
    public CustomerPage clickLogoutButton() {
        LogoutButton().click();
        return this;
    }
    public String getName() {
        return Name().getText();
    }
    public String getAccountNumber() {
        return AccountNumber().getText();
    }
    public String getAccountBalance() {
        return AccountBalance().getText();
    }
    public String getAccountCurrency() {
        return AccountCurrency().getText();
    }
    public CustomerPage selectAccount(String accString) {
        AccountSelectField().selectByVisibleText(accString);
        return this;
    }
}
