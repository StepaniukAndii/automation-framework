package tests;


import lombok.extern.log4j.Log4j;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CustomerWithdrawlPage;

@Log4j
public class TestCustomerWithdrawlPageElements extends TestInit {

    @Test
    public void testWithdrawlPageElements() {
        CustomerWithdrawlPage customerWithdrawlPage = new CustomerWithdrawlPage(driver);
        log.info("--------------------go to Customer Withdrawl Page--------------------");
        customerWithdrawlPage
                .goToWithdrawlPage();
        log.info("--------------------check elements on page--------------------");
        Assert.assertTrue(customerWithdrawlPage.labelWithdrawl().isDisplayed(),"Assert is fail");
        Assert.assertTrue(customerWithdrawlPage.inputWithdrawl().isDisplayed(),"Assert is fail");
        Assert.assertTrue(customerWithdrawlPage.buttonWithdrawl().isDisplayed(),"Assert is fail");


    }

    @Test
    public void testWithdrawlPage() {
        log.info("--------------------go to Customer Withdrowl Page--------------------");
        CustomerWithdrawlPage customerWithdrawlPage = new CustomerWithdrawlPage(driver);
        customerWithdrawlPage
                .goToWithdrawlPage()
                .enterInputWithdrawl("10")
                .clickButtonWithdrawl();
        log.info("--------------------check message--------------------");
        Assert.assertTrue(customerWithdrawlPage.messageWithdrawl().isDisplayed(), "Assert is fail");


    }
}