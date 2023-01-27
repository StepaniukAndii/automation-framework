package tests.home;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import tests.TestInit;

public class TestVerification extends TestInit {
    @Test
    public void checkClickCustomerLoginBtn(){
        String s = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/customer";
        HomePage homePage = new HomePage(driver);
        homePage
                .open()
                .clickCustomerLoginBtn();

        Assert.assertEquals(getUrl("customer"), s);
    }

    @Test
    public void checkClickBankManagerLogin(){
        String b = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager";
        HomePage homePage = new HomePage(driver);
        homePage
                .open()
                .clickBankManagerLoginBtn();

        Assert.assertEquals(getUrl("manager"), b);
    }

    @Test
    public void checkoutHeader(){
        HomePage homePage = new HomePage(driver);
        homePage
                .open();
        Assert.assertEquals(driver.getTitle(), "XYZ Bank");
        Assert.assertTrue(homePage.getCustomerLoginBtn().isDisplayed());
        Assert.assertTrue(homePage.getBankManagerLoginBtn().isDisplayed());
    }
}
