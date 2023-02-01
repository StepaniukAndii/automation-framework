package pages;

import basePages.AbstractBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ManagerCustomersPage extends AbstractBasePage {

    public ManagerCustomersPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ManagerCustomersPage open() {
        openUrl(env + "manager/list");
        return this;
    }

    private final static String CUSTOMERS_SEARCH = "//input[@ng-model='searchCustomer']";
    private final static String F_NAME_SORT = "//thead/tr/td/a[1]";
    private final static String L_NAME_SORT = "//thead/tr/td/a[2]";
    private final static String POST_CODE_SORT = "//thead/tr/td/a[3]";
    private final static String F_NAME = "//tbody/tr[@class='ng-scope']/td[1]";
    private final static String L_NAME = "//tbody/tr[@class='ng-scope']/td[2]";
    private final static String POST_CODE = "//tbody/tr[@class='ng-scope']/td[3]";
    private final static String ACCOUNT_NUMBER = "//tbody/tr[@class='ng-scope']/td[4]";
    private final static String DELETE_BUTTON = "//tr[1]//button[text()='Delete']";


    public WebElement searchCustomers() {
        return waitClickableElementByXpath(CUSTOMERS_SEARCH);
    }

    public WebElement sortFName() {
        return waitClickableElementByXpath(F_NAME_SORT);
    }

    public WebElement sortLName() {
        return waitClickableElementByXpath(L_NAME_SORT);
    }

    public WebElement sortPostCode() {
        return waitClickableElementByXpath(POST_CODE_SORT);
    }

    public WebElement fName() {
        return waitVisibleOfElement(F_NAME);
    }

    public WebElement lName() {
        return waitVisibleOfElement(L_NAME);
    }

    public WebElement postCode() {
        return waitVisibleOfElement(POST_CODE);
    }

    public WebElement accountNumber() {
        return waitVisibleOfElement(ACCOUNT_NUMBER);
    }

    public WebElement deleteCustomer() {
        return waitClickableElementByXpath(DELETE_BUTTON);
    }

    public List<WebElement> accountList() {
        return $$x("//tr[@class='ng-scope']/td[4]/span");
    }

    //HELP METHODS

    public ManagerCustomersPage search(String text) {
        sendText(searchCustomers(), text);
        return this;
    }

    public ManagerCustomersPage sortedFirstName() {
        sortFName().click();
        return this;
    }

    public ManagerCustomersPage sortedLastName() {
        sortLName().click();
        return this;
    }

    public ManagerCustomersPage sortedPostCode() {
        sortPostCode().click();
        return this;
    }


    public ManagerCustomersPage clickDeleteBtn() {
        deleteCustomer().click();
        return this;
    }

    public String selectAccount() {
        List<String> accounts = new ArrayList<>();
        accountList().forEach(x -> accounts.add(x.getText()));
        return accounts.get(accounts.size() - 1);


    }
}

