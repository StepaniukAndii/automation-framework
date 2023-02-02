package pages;

import basePages.AbstractBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomerWithdrawlPage extends AbstractBasePage {


    public CustomerWithdrawlPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public CustomerWithdrawlPage open() {
        openUrl(env + "account");
        return this;
    }

    public CustomerWithdrawlPage openByUser(String user) {
        new CustomerPage(driver).openByUser(user).clickWithdrawButton();
        return this;
    }

    private final static String LABEL_WITHDRAWL = "//label[text()='Amount to be Withdrawn :']";
    private final static String INPUT_WITHDRAWL = "//input[@ng-model='amount']";
    private final static String BUTTON_WITHDRAWL = "//button[text()='Withdraw']";
    private final static String MESSAGE_WITHDRAWL = "//span[text()='Transaction successful']";

    public WebElement labelWithdrawl() {
        return waitVisibleOfElement(LABEL_WITHDRAWL);
    }

    public WebElement inputWithdrawl() {
        return waitClickableElementByXpath(INPUT_WITHDRAWL);
    }

    public WebElement buttonWithdrawl() {
        return waitClickableElementByXpath(BUTTON_WITHDRAWL);
    }

    public WebElement messageWithdrawl() {
        return waitVisibleOfElement(MESSAGE_WITHDRAWL);
    }

    // HELP METHODS
    public CustomerWithdrawlPage enterInputWithdrawl(int sum) {
        inputWithdrawl().sendKeys(String.valueOf(sum));
        return this;
    }

    public CustomerPage clickButtonWithdrawl() {
        buttonWithdrawl().click();
        return new CustomerPage(driver);
    }
}
