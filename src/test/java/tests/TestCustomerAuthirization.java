package tests;


import healper.Currency;
import healper.Customer;
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
    private Customer customer;

    @BeforeTest
    public void setup() {
        customerLoginPage = new CustomerLoginPage(driver);
        customer = Customer.builder().build();

        customerLoginPage.createCustomerAndAccount(customer, Currency.POUND);
    }

    @AfterTest
    public void teardown() {
        customerLoginPage.deleteCustomer(customer);
    }

    @Test
    public void testAuthirization() {
        log.info("--------------------go to Customer Login Page--------------------");
        customerLoginPage.open();

        log.info(String.format("--------------------select user %s--------------------", customer.getFirstName()));
        customerLoginPage.selectUser(customer.getFirstName());
        Assert.assertTrue(customerLoginPage.loginBtn().isDisplayed(), "Login button is not displayed");

        log.info("--------------------login--------------------");
        customerPage = customerLoginPage.clickLoginBtn();

        log.info("--------------------verify login--------------------");
        Assert.assertEquals(customerPage.getName(), customer.getFirstName(), "The login does not match");
    }
}
