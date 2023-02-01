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
    private final static String first_name = "Jack";
    private final static String last_name = "the Ripper";
    private final static String user_name = first_name + last_name;
    @BeforeTest
    public void setup() {
        customerLoginPage = new CustomerLoginPage(driver);
        createCustomer(first_name, last_name, "E1 0AA", "Pound");
    }
    @AfterTest
    public void teardown()
    {
        deleteCustomer(first_name);
    }
    @Test
    public void testAuthirization() {
        log.info("--------------------go to Customer Login Page--------------------");
        customerLoginPage.open();

        log.info(String.format("--------------------select user %s--------------------", user_name));
        customerLoginPage.selectUser(user_name);
        Assert.assertTrue(customerLoginPage.loginBtn().isDisplayed(), "Login button is not displayed");

        log.info("--------------------login--------------------");
        customerPage = customerLoginPage.clickLoginBtn();
        
        log.info("--------------------verify login--------------------");
        Assert.assertEquals(customerPage.getName(), user_name, "The login does not match"); 
    }
}
