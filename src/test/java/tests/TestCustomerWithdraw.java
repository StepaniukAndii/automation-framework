package tests;


import lombok.extern.log4j.Log4j;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CustomerWithdrawlPage;

@Log4j
public class TestCustomerWithdraw extends TestInit {

    @Test
    public void testWithdrawlPageElements() {
        CustomerWithdrawlPage customerWithdrawlPage = new CustomerWithdrawlPage(driver);

        customerWithdrawlPage.openByUser("Ron Weasly");

        Assert.assertTrue(customerWithdrawlPage.labelWithdrawl().isDisplayed(), "Assert is fail");
        Assert.assertTrue(customerWithdrawlPage.inputWithdrawl().isDisplayed(), "Assert is fail");
        Assert.assertTrue(customerWithdrawlPage.buttonWithdrawl().isDisplayed(), "Assert is fail");


    }

    @Test
    public void testWithdrawlPage() {
        CustomerWithdrawlPage customerWithdrawlPage = new CustomerWithdrawlPage(driver);

//        customerWithdrawlPage
//                .goToWithdrawlPage()
//                .enterInputWithdrawl("10")
//                .clickButtonWithdrawl();

        Assert.assertTrue(customerWithdrawlPage.messageWithdrawl().isDisplayed(), "Assert is fail");
    }
}