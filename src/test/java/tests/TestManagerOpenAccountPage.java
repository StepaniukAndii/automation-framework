package tests;


import lombok.extern.log4j.Log4j;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ManagerOpenAccountPage;

@Log4j
public class TestManagerOpenAccountPage extends TestInit {


    @Test
    public void testManagerOpenAccountPageElements() {
        ManagerOpenAccountPage managerOpenAccountPage = new ManagerOpenAccountPage(driver);
        log.info("--------------------go to Open account Page--------------------");
        managerOpenAccountPage
                .goToManagerOpenAccountPage();
        log.info("--------------------check elements on page--------------------");
        Assert.assertTrue(managerOpenAccountPage.selectCustomer().isDisplayed(), "Assert is fail");
        Assert.assertTrue(managerOpenAccountPage.selectCurrency().isDisplayed(), "Assert is fail");
        Assert.assertTrue(managerOpenAccountPage.progressBtn().isDisplayed(), "Assert is fail");

    }
}