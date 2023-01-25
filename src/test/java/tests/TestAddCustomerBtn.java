package tests;


import lombok.extern.log4j.Log4j;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ManagerAddCustomerPage;

@Log4j
public class TestAddCustomerBtn extends TestInit {

    @Test
    public void checkAddCustomer() {

        ManagerAddCustomerPage managerAddCustomerPage = new ManagerAddCustomerPage(driver);
        managerAddCustomerPage
                .open();
        Assert.assertTrue(managerAddCustomerPage.getFirstNameField().isDisplayed(), "Assert is failed");
        Assert.assertTrue(managerAddCustomerPage.getLastName().isDisplayed(), "Assert is failed");
        Assert.assertTrue(managerAddCustomerPage.getPostCode().isDisplayed(), "Assert is failed");
        Assert.assertTrue(managerAddCustomerPage.addCustomerSubmit().isDisplayed(), "Assert is failed");

    }
}
