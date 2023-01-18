package tests;

import Pages.CustomerLoginPage;
import org.testng.annotations.Test;

public class TestCustomerLogPage extends TestInit {

    @Test
    public void checkLogPage() {
        CustomerLoginPage customerLoginPage = new CustomerLoginPage(driver);

        customerLoginPage
                .open()
                .clickUserThree()
                .clickLoginBtn();
    }
}
