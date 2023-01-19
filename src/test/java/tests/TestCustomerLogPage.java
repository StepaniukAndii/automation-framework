package tests;

import elements.HeaderElements;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CustomerLoginPage;

public class TestCustomerLogPage extends TestInit {

    @Test
    public void checkLogPage() {
        CustomerLoginPage customerLoginPage = new CustomerLoginPage(driver);
        HeaderElements headerElements = new HeaderElements(driver);

        customerLoginPage
                .open()
                .clickUser(1)
                .clickLoginBtn();

    }
}
