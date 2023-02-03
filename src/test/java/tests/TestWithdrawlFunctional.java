package tests;

import healper.Currency;
import healper.Customer;
import healper.HelperTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CustomerPage;

public class TestWithdrawlFunctional extends TestInit {

    private final static int DEPOSIT_SUM = 400;
    private final static int WITHDRAW_SUM = 200;
    private int balance;
    Customer customer = Customer.builder().build();
    HelperTest helperTest;

    @BeforeMethod
    private void beforeMethod() {
        helperTest = new HelperTest(driver);
    }

    @AfterMethod
    private void deleteCustomer() {
        helperTest.deleteCustomer(customer);
    }

    @Test
    public void checkWithdrawFunctionality() {
        helperTest
                .createCustomerAndAccount(customer, Currency.DOLLAR)
                .clickCustomerLoginBtn()
                .selectUser(customer.getFirstName())
                .clickLoginBtn();

        CustomerPage customerPage = new CustomerPage(driver);
        balance = customerPage.getAccountBalance() + DEPOSIT_SUM;

        customerPage.clickDepositButton()
                .setAmount(DEPOSIT_SUM)
                .clickDepositBtn();

        Assert.assertEquals(customerPage.getAccountBalance(), balance);

        balance = customerPage.getAccountBalance() - WITHDRAW_SUM;

        customerPage.clickWithdrawButton()
                .enterInputWithdrawl(WITHDRAW_SUM)
                .clickButtonWithdrawl();

        Assert.assertEquals(customerPage.getAccountBalance(), balance);
    }
}
