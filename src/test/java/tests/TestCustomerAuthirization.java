package tests;


import lombok.extern.log4j.Log4j;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.CustomerLoginPage;
import pages.CustomerPage;
import pages.ManagerOpenAccountPage;

@Log4j
public class TestCustomerAuthirization extends TestInit {

    CustomerLoginPage customerLoginPage;
    CustomerPage customerPage;

    @BeforeTest
    public void setup() {
        customerLoginPage = new CustomerLoginPage(driver);
        customerPage = new CustomerPage(driver);
    }
    @Test
    public void testAuthirization() {
        
        log.info("--------------------go to Customer Login Page--------------------");
    }
}
