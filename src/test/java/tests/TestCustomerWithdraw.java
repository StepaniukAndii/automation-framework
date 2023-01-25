package tests;


import lombok.extern.log4j.Log4j;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CustomerDepositPage;
import pages.CustomerPage;
import pages.CustomerWithdrawlPage;

@Log4j
public class TestCustomerWithdraw extends TestInit {

    private final String user = "Neville Longbottom";
    private final String MESSAGE_WITHDRAW = "Transaction successful";

    @Test
    public void verifyWithdraw() {
        CustomerWithdrawlPage customerWithdrawlPage = new CustomerWithdrawlPage(driver);

        customerWithdrawlPage.openByUser(user);

        Assert.assertTrue(customerWithdrawlPage.labelWithdrawl().isDisplayed(), "Assert is fail");
        Assert.assertTrue(customerWithdrawlPage.inputWithdrawl().isDisplayed(), "Assert is fail");
        Assert.assertTrue(customerWithdrawlPage.buttonWithdrawl().isDisplayed(), "Assert is fail");


    }

    @Test
    public void checkWithdraw() {


        CustomerDepositPage customerDepositPage = new CustomerDepositPage(driver);
        customerDepositPage
                .openByUser(user)
                .setAmount(100)
                .clickDepositBtn();


        CustomerWithdrawlPage customerWithdrawlPage = new CustomerWithdrawlPage(driver);
        customerWithdrawlPage
                .openByUser(user)
                .enterInputWithdrawl("10")
                .clickButtonWithdrawl();

        Assert.assertTrue(customerWithdrawlPage.messageWithdrawl().isDisplayed(), "assert is fail");
        Assert.assertEquals(customerWithdrawlPage.messageWithdrawl().getText(),MESSAGE_WITHDRAW, "assert is fail" );




    }
}