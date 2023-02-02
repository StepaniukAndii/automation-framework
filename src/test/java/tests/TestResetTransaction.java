package tests;

import healper.Currency;
import healper.Customer;
import healper.HelperTest;
import org.testng.annotations.Test;
import pages.CustomerLoginPage;
import pages.CustomerPage;

public class TestResetTransaction extends TestInit {
    private HelperTest helperTest;
    private CustomerLoginPage customerLoginPage;
    private CustomerPage customerPage;

    @Test
    public void checkResetTrans() {
        helperTest = new HelperTest(driver);
        Customer customer = Customer.builder().firstName().build();

        helperTest
                .createCustomer(customer, Currency.DOLLAR);

    }

}