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

    private CustomerLoginPage customerLoginPage;
    private CustomerPage customerPage;
    private final static String firstName = "Jack";
    private final static String lastName = "the Ripper";
    private final static String userName = firstName + lastName;
    @BeforeTest
    public void setup() {
        customerLoginPage = new CustomerLoginPage(driver);
        createCustomer(firstName, lastName, "E1 0AA", "Pound");
    }
    @AfterTest
    public void teardown()
    {
        deleteCustomer(firstName);
    }
    @Test
    public void testAuthirization() {
        log.info("--------------------go to Customer Login Page--------------------");
        customerLoginPage.open();

        log.info(String.format("--------------------select user %s--------------------", userName));
        customerLoginPage.selectUser(userName);
        Assert.assertTrue(customerLoginPage.loginBtn().isDisplayed(), "Login button is not displayed");

        log.info("--------------------login--------------------");
        customerPage = customerLoginPage.clickLoginBtn();
        
        log.info("--------------------verify login--------------------");
        Assert.assertEquals(customerPage.getName(), userName, "The login does not match"); 
    }
}
