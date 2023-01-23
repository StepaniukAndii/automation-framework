package tests;

import elements.HeaderElements;
import org.openqa.selenium.Alert;
import org.testng.annotations.Test;
import pages.ManagerAddCustomerPage;


public class TestAddCustomerBtn extends TestInit {

    @Test
    public void checkAddCustomer() {

        ManagerAddCustomerPage managerAddCustomerPage = new ManagerAddCustomerPage(driver);
        managerAddCustomerPage
                .open()
                .clickAddCustomerBtn()
                .enterRegistrationCredits("Vova", "Ironman", "12345")
                .clickAddCustSubmit();

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
    }
}
