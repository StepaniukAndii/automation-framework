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
    String USER_FIRST_NAME = "Jack";
    String USER_LAST_NAME = "the Ripper";
    String USER_NAME = USER_FIRST_NAME + USER_LAST_NAME;
    @BeforeTest
    public void setup() {
        customerLoginPage = new CustomerLoginPage(driver);
        createCustomer(USER_FIRST_NAME, USER_LAST_NAME, "E1 0AA", "Pound");
    }
    @AfterTest
    public void teardown()
    {
        deleteCustomer(USER_FIRST_NAME);
    }
    @Test
    public void testAuthirization() {
        log.info("--------------------go to Customer Login Page--------------------");
        customerLoginPage.open();

        log.info(String.format("--------------------select user %s--------------------", USER_NAME));
        customerLoginPage.selectUser(USER_NAME);
        Assert.assertTrue(customerLoginPage.loginBtn().isDisplayed(), "Login button is not displayed");

        log.info("--------------------login--------------------");
        customerPage = customerLoginPage.clickLoginBtn();
        
        log.info("--------------------verify login--------------------");
        Assert.assertEquals(customerPage.getName(), USER_NAME, "The login does not match"); 
    }
}
