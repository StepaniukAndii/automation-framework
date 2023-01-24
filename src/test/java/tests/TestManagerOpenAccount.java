package tests;


import lombok.extern.log4j.Log4j;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ManagerOpenAccountPage;

@Log4j
public class TestManagerOpenAccount extends TestInit {


    @Test
    public void verifyManagerOpenAccount() {
        ManagerOpenAccountPage managerOpenAccountPage = new ManagerOpenAccountPage(driver);

        managerOpenAccountPage.open();

        Assert.assertTrue(managerOpenAccountPage.selectCustomer().isDisplayed(), "Assert is fail");
        Assert.assertTrue(managerOpenAccountPage.selectCurrency().isDisplayed(), "Assert is fail");
        Assert.assertTrue(managerOpenAccountPage.progressBtn().isDisplayed(), "Assert is fail");
    }
}