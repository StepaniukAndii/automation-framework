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
import pages.CustomerTransactions;

public class TestResetTransaction extends TestInit {
    private HelperTest helperTest;
    private CustomerLoginPage customerLoginPage;
    private CustomerPage customerPage;
    private CustomerDepositPage customerDepositPage;
    private CustomerTransactions customerTransactions;
    Customer customer = Customer.builder().build();


    @BeforeMethod
    private void createCustomerNAccount() {
        helperTest = new HelperTest(driver);
        helperTest.createCustomerAndAccount(customer, Currency.DOLLAR);
    }

    @AfterMethod
    private void deleteCustomer() {
        helperTest.deleteCustomer(customer);
    }


    @Test
    public void checkResetTrans() {
        customerPage = new CustomerPage(driver);
        customerDepositPage = new CustomerDepositPage(driver);
        customerTransactions = new CustomerTransactions(driver);

        customerDepositPage
                .openByUser(customer.getFullName())
                .setAmount(400)
                .clickDepositBtn()
                .clickTransactionButton();
                //.clickResetBtn();

        Assert.assertTrue(customerTransactions.tablet().isEnabled());

    }

}