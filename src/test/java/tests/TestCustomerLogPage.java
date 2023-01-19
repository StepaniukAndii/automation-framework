package tests;

import elements.HeaderElements;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CustomerLoginPage;

public class TestCustomerLogPage extends TestInit{
    @Test
    public void checkLoginProcess(){
        CustomerLoginPage customerLoginPage = new CustomerLoginPage(driver);
        HeaderElements headerElements = new HeaderElements(driver);
        customerLoginPage
                .open()
                .clickUser(3)
                .clickLoginBtn();
        Assert.assertTrue(headerElements.getHeader().isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/customer");
        Assert.assertEquals(customerLoginPage.getHeaderElements().getHeader().getText(), "XYZ Bank");
    }
}
