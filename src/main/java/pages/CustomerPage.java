package pages;

import elements.CustomerPageElements;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CustomerPage extends CustomerPageElements {

    public CustomerPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public CustomerPage open() {
        openUrl(env + "account");
        return this;
    }

    public CustomerPage openByUser(String user) {
        new CustomerLoginPage(driver)
                .open()
                .selectUser(user)
                .clickLoginBtn();
        return this;
    }

    public CustomerTransactions clickTransactionButton() {
        transactionButton().click();
        return new CustomerTransactions(driver);
    }

    public CustomerDepositPage clickDepositButton() {
        depositButton().click();
        return new CustomerDepositPage(driver);
    }

    @SneakyThrows
    public CustomerWithdrawlPage clickWithdrawButton() {
        withdrawButton().click();
        Thread.sleep(500);
        return new CustomerWithdrawlPage(driver);
    }

    public CustomerLoginPage clickLogoutButton() {
        logoutButton().click();
        return new CustomerLoginPage(driver);
    }

    public String getName() {
        return name().getText();
    }

    public String getAccountNumber() {
        return accountNumber().getText();
    }

    public int getAccountBalance() {
        return Integer.parseInt(accountBalance().getText());

    }

    public String getAccountCurrency() {
        return accountCurrency().getText();
    }

    public CustomerPage selectAccount(String accString) {
        new Select(accountSelectField()).selectByVisibleText(accString);
        return this;
    }
}
