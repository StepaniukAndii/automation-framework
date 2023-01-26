package tests;


import lombok.extern.log4j.Log4j;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CustomerWithdrawlPage;

@Log4j
public class TestCustomerWithdraw extends TestInit {

    private final String user = "Ron Weasly";

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
        CustomerWithdrawlPage customerWithdrawlPage = new CustomerWithdrawlPage(driver);

        customerWithdrawlPage.openByUser(user);



        customerWithdrawlPage
                .enterInputWithdrawl("10")
                .clickButtonWithdrawl();

        Assert.assertTrue(customerWithdrawlPage.messageWithdrawl().isDisplayed(), "Assert is fail");
    }
}