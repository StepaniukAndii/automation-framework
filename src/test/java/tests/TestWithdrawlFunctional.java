package tests;

import healper.HelperTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CustomerPage;

public class TestWithdrawlFunctional extends TestInit {

    private final static String USER_FIRST_NAME = "Bohdan";
    private final static String USER_LAST_NAME = "Moskvin";
    private final static String USER_NAME = "Bohdan Moskvin";
    private final static String POST_CODE = "1452";
    private final static String CURRENCY = "Dollar";
    private final static int DEPOSIT_SUM = 400;
    private final static int WITHDRAW_SUM = 200;
    private int balance;

    @Test
    public void checkWithdrawlFunctionality(){
        HelperTest helperTest = new HelperTest(driver);
        helperTest
                .createCustomer(USER_FIRST_NAME,USER_LAST_NAME, POST_CODE, CURRENCY)
                .clickCustomerLoginBtn()
                .selectUser(USER_NAME)
                .clickLoginBtn();

        CustomerPage customerPage = new CustomerPage(driver);
        balance = customerPage.getAccountBalance()+DEPOSIT_SUM;

        customerPage.clickDepositButton()
                .setAmount(DEPOSIT_SUM)
                .clickDepositBtn();

        Assert.assertEquals(customerPage.getAccountBalance(), balance);

        balance = customerPage.getAccountBalance()-WITHDRAW_SUM;

        customerPage.clickWithdrawButton()
                .enterInputWithdrawl(WITHDRAW_SUM)
                .clickButtonWithdrawl();

        Assert.assertEquals(customerPage.getAccountBalance(), balance);

        helperTest.deleteCustomer(USER_FIRST_NAME);

    }
}
