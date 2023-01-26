package pages;

import basePages.AbstractBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ManagerCustomersPage extends AbstractBasePage {

    public ManagerCustomersPage(WebDriver driver) {
        super(driver);

    }

    @Override
    public ManagerCustomersPage open() {
        openUrl(env + "manager");
        return this;
    }

    private static final String FIRST_NAME = "//a[contains(text() , 'First Name')]";
    private static final String LAST_NAME = "//a[contains(text() , 'Last Name')]";
    private static final String POST_CODE = "//a[contains(text() , 'Post Code')]";
    private static final String ACCOUNT_NUMBER = "//a[contains(text() , 'Account Number')]";
    private static final String DELETE_CUSTOMER = "//a[contains(text() , 'Delete Customer')]";

    public WebElement firstCustomerName() {
        return waitVisibleOfElement(FIRST_NAME);
    }
    public WebElement lastCustomerName() {
        return waitVisibleOfElement(LAST_NAME);
    }

    public WebElement postCode() {
        return waitVisibleOfElement(POST_CODE);
    }
    public WebElement accNumber() {
        return waitVisibleOfElement(ACCOUNT_NUMBER);
    }


    public ManagerCustomersPage searchCustomerByFirstName(String name) {
            sendText(firstCustomerName(), name);
            return this;
        }


    public ManagerCustomersPage searchCustomerByLastName(String name1) {
        sendText(lastCustomerName(), name1);
        return this;
    }
    public ManagerCustomersPage searchCustomerByPostIndex(String postIndex) {
        sendText(postCode(), postIndex);
        return this;
    }

    public WebElement delCustomer() {
        return waitVisibleOfElement(DELETE_CUSTOMER);
    }
}

