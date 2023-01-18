package tests;

import Pages.CustomerLoginPage;
import elements.CustomerCabinetElements;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCustomerLogPage extends TestInit {

    @Test
    public void checkLogPage() {
        CustomerLoginPage customerLoginPage = new CustomerLoginPage(driver);
        CustomerCabinetElements customerCabinetElements = new CustomerCabinetElements(driver);

        customerLoginPage
                .open()
                .clickUserThree()
                .clickLoginBtn();
        Assert.assertEquals(customerCabinetElements.getCredentialsInCabinet().getText(), "Ron Weasly");
    }
}
