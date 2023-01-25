package tests;


import lombok.extern.log4j.Log4j;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ManagerOpenAccountPage;

@Log4j
public class TestManagerOpenAccount extends TestInit {


    @Test
    public void verifyManagerOpenAccount() {

        ManagerOpenAccountPage managerOpenAccountPage = new ManagerOpenAccountPage(driver);
        managerOpenAccountPage
                .open()
                .selectCustomer("Neville Longbottom")
                .selectCurrency("Dollar")
                .clickProgressBtn();

        Assert.assertEquals(managerOpenAccountPage.alertMessagePrint(),"1016");

    }

   }