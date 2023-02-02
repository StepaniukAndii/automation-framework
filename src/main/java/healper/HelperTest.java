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

    public HomePage createCustomerAndAccount(Customer customer, Currency currency) {
        String currencyValue;
        if (Currency.DOLLAR == currency) {
            currencyValue = "Dollar";
        } else if (currency == Currency.POUND) {
            currencyValue = "Pound";
        } else {
            currencyValue = "Rupee";
        }

        ManagerAddCustomerPage managerAddCustomerPage = new ManagerAddCustomerPage(driver);
        managerAddCustomerPage
                .open()
                .enterRegistrationCredits(customer.getFirstName(), customer.getLastName(), customer.getPostCode())
                .clickOpenAccountBtn()
                .openAccount(customer.getFirstName()+ " " + customer.getLastName(), currencyValue)
                .clickHomeBtn();
        return new HomePage(driver);

    }

    public HomePage deleteCustomer(Customer customer) {
        ManagerCustomersPage managerCustomersPage = new ManagerCustomersPage(driver);
        managerCustomersPage
                .open()
                .search(customer.getFirstName())
                .clickDeleteBtn();

        return new HomePage(driver);
    }

    @Override
    public <T> T open() {
        return null;
    }
}
