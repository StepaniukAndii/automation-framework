package tests;

import healper.Currency;
import healper.Customer;
import healper.HelperTest;
import lombok.extern.log4j.Log4j;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.CustomerDepositPage;
import pages.CustomerPage;

@Log4j
public class TestDepositFunctionality extends TestInit {

    private static final int DEPOSIT_SUM = 100;
    private static final String MESSAGE = "Deposit Successful";
    private static final int WITHDROW_SUM = 50;
    public int balance;

    private HelperTest helperTest;
    private CustomerDepositPage customerDepositPage;
    private CustomerPage customerPage;
    private Customer customer;

    @AfterMethod
    private void deleteCustomer() {
        helperTest.deleteCustomer(customer);
    }

    @Test
    public void testDepositPage() {
        log.info("====================CREATE NEW CUSTOMER====================");
        helperTest = new HelperTest(driver);
        customer = Customer.builder().build();
        helperTest.createCustomerAndAccount(customer, Currency.DOLLAR);

        log.info("====================GO TO CUSTOMER DEPOSIT PAGE====================");
        customerDepositPage = new CustomerDepositPage(driver);
        customerDepositPage
                .openByUser(customer.getFullName());

        log.info("====================ASSERT ELEMENTS ON CUSTOMER DEPOSIT PAGE====================");
        Assert.assertTrue(customerDepositPage.getAmountLabelDeposit().isDisplayed(), "!ELEMENT IS FAIL!");
        Assert.assertTrue(customerDepositPage.amountSelect().isDisplayed(), "!ELEMENT IS FAIL!");
        Assert.assertTrue(customerDepositPage.depositBtn().isDisplayed(), "!ELEMENT IS FAIL!");
    }

    @Test
    public void testDepositFunctional() {
        log.info("====================CREATE NEW CUSTOMER====================");
        helperTest = new HelperTest(driver);
        customer = Customer.builder().build();
        helperTest.createCustomerAndAccount(customer, Currency.POUND);

        log.info("====================GO TO CUSTOMER DEPOSIT PAGE====================");
        customerDepositPage = new CustomerDepositPage(driver);
        log.info("====================DEPOSIT MONEY INTO THE ACCOUNT====================");
        customerDepositPage
                .openByUser(customer.getFullName())
                .setAmount(DEPOSIT_SUM)
                .clickDepositBtn();

        log.info("====================ASSERT MESSAGE ON CUSTOMER DEPOSIT PAGE====================");
        Assert.assertTrue(customerDepositPage.depositMessage().isDisplayed(), "!ELEMENT IS FAIL!");
        Assert.assertEquals(customerDepositPage.setDepositMessage(), MESSAGE, "! ASSERT IS FAIL !");
    }

    @Test
    public void testDepositFunctionalBalance() {
        log.info("====================CREATE NEW CUSTOMER====================");
        helperTest = new HelperTest(driver);
        customer = Customer.builder().build();
        helperTest.createCustomerAndAccount(customer, Currency.RUPEE);

        log.info("====================GO TO CUSTOMER PAGE====================");
        customerPage = new CustomerPage(driver);
        customerPage
                .openByUser(customer.getFullName());

        log.info("====================CHECK EXPECTED DEPOSIT BALANCE====================");
        balance = customerPage.getAccountBalance() + DEPOSIT_SUM;

        log.info("====================DEPOSIT MONEY INTO THE ACCOUNT====================");
        customerPage
                .clickDepositButton()
                .setAmount(DEPOSIT_SUM)
                .clickDepositBtn();

        log.info("====================ASSERT DEPOSIT BALANCE====================");
        Assert.assertEquals(customerPage.getAccountBalance(), balance, "! ASSERT IS FAIL !");

        log.info("====================CHECK EXPECTED DEPOSIT BALANCE====================");
        balance = customerPage.getAccountBalance() - WITHDROW_SUM;

        log.info("====================WITHDROW MONEY INTO THE ACCOUNT====================");
        customerPage
                .clickWithdrawButton()
                .enterInputWithdrawl(WITHDROW_SUM)
                .clickButtonWithdrawl();

        log.info("====================ASSERT WITHDROW BALANCE====================");
        Assert.assertEquals(customerPage.getAccountBalance(), balance, "! ASSERT IS FAIL !");
    }
}
