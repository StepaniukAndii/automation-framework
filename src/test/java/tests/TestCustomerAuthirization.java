package tests;


import lombok.extern.log4j.Log4j;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.CustomerLoginPage;
import pages.CustomerPage;

@Log4j
public class TestCustomerAuthirization extends TestInit {

    CustomerLoginPage customerLoginPage;
    CustomerPage customerPage;
    String USER = "Harry Potter";
    @BeforeTest
    public void setup() {
        customerLoginPage = new CustomerLoginPage(driver);
        createCustomer("Jack", "the Ripper", "E1 0AA", "Pound");
    }
    @AfterTest
    public void teardown()
    {
        deleteCustomer("Jack");
    }
    @Test
    public void testAuthirization() {
        log.info("--------------------go to Customer Login Page--------------------");
        customerLoginPage.open();

        log.info(String.format("--------------------select user %s--------------------", USER));
        customerLoginPage.selectUser(USER);
        Assert.assertTrue(customerLoginPage.loginBtn().isDisplayed(), "Login button is not displayed");

        log.info("--------------------login--------------------");
        customerPage = customerLoginPage.clickLoginBtn();
        
        log.info("--------------------verify login--------------------");
        Assert.assertEquals(customerPage.getName(), USER, "The login does not match"); 
    }
}
