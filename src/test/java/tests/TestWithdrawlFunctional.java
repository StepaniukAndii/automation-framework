package tests;

import healper.Currency;
import healper.Customer;
import healper.HelperTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CustomerDepositPage;
import pages.CustomerLoginPage;
import pages.CustomerPage;
import pages.CustomerWithdrawlPage;

public class TestWithdrawlFunctional extends TestInit {

    private CustomerDepositPage customerDepositPage;
    private CustomerLoginPage customerLoginPage;
    private CustomerPage customerPage;
    private CustomerWithdrawlPage customerWithdrawlPage;
    private HelperTest helperTest;
    private final static int DEPOSIT_SUM = 400;
    private final static int WITHDRAW_SUM = 200;
    private int balance;
    Customer customer = Customer.builder().build();

    @BeforeMethod
    private void createCustomerAccount() {
        helperTest = new HelperTest(driver);
        helperTest.createCustomerAndAccount(customer, Currency.DOLLAR);
    }

    @AfterMethod
    private void deleteCustomer() {
        helperTest.deleteCustomer(customer);
    }

    @Test
    public void checkWithdrawFunctionality() {
        customerPage = new CustomerPage(driver);
        customerDepositPage = new CustomerDepositPage(driver);
        customerWithdrawlPage = new CustomerWithdrawlPage(driver);

        customerDepositPage
                .openByUser(customer.getFullName())
                .setAmount(DEPOSIT_SUM)
                .clickDepositBtn();

        balance = customerPage.getAccountBalance() - WITHDRAW_SUM;
        customerPage
                .clickWithdrawButton()
                .enterInputWithdrawl(WITHDRAW_SUM)
                .clickButtonWithdrawl();

        Assert.assertEquals(customerPage.getAccountBalance(), balance);
    }
}
