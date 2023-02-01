package healper;

import basePages.AbstractBasePage;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.ManagerAddCustomerPage;
import pages.ManagerCustomersPage;

public class HelperTest extends AbstractBasePage {

    public HelperTest(WebDriver driver) {
        super(driver);
    }

    public HomePage createCustomer(String firstName, String lastName, String postCode, String currency) {
        ManagerAddCustomerPage managerAddCustomerPage = new ManagerAddCustomerPage(driver);
        managerAddCustomerPage
                .open()
                .enterRegistrationCredits(firstName, lastName, postCode)
                .clickOpenAccountBtn()
                .openAccount(firstName + " " + lastName, currency)
                .clickHomeBtn();
        return new HomePage(driver);

    }

    public HomePage deleteCustomer(String name) {
        ManagerCustomersPage managerCustomersPage = new ManagerCustomersPage(driver);
        managerCustomersPage
                .open()
                .search(name)
                .clickDeleteBtn();

        return new HomePage(driver);
    }

    @Override
    public <T> T open() {
        return null;
    }
}
