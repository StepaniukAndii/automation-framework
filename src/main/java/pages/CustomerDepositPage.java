package pages;

import basePages.AbstractBasePage;
import elements.HeaderElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomerDepositPage extends AbstractBasePage {

    private HeaderElements headerElements;

    public CustomerDepositPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public CustomerDepositPage open() {
        openUrl(env + "account");
        return this;
    }

    public CustomerDepositPage openByUser(String user) {
        new CustomerPage(driver).openByUser(user).clickDepositButton();
        return this;
    }

    public HeaderElements getHeaderElements() {
        if (headerElements == null) {
            return headerElements = new HeaderElements(driver);
        } else {
            return headerElements;
        }
    }

    private final static String LABEL_AMOUNT_DEPOSIT = "//label";
    private final static String AMOUNT_SELECT = "//input[@type='number']";
    private final static String DEPOSIT_BTN = "//button[@type='submit']";
    private final static String DEPOSIT_MESSAGE = "//div[@class='ng-scope']/span[@ng-show='message']";

    public WebElement getAmountLabelDeposit() {
        return waitVisibleOfElement(LABEL_AMOUNT_DEPOSIT);
    }

    public WebElement amountSelect() {
        return waitClickableElementByXpath(AMOUNT_SELECT);
    }

    public WebElement depositBtn() {
        return waitClickableElementByXpath(DEPOSIT_BTN);
    }

    public WebElement depositMessage() {
        return waitVisibleOfElement(DEPOSIT_MESSAGE);
    }

    public CustomerDepositPage setAmount(int baksu) {
        amountSelect().sendKeys(String.valueOf(baksu));
        return this;
    }

    public String setDepositMessage() {
        return depositMessage().getText();

    }

    public CustomerPage clickDepositBtn() {
        depositBtn().click();
        return new CustomerPage(driver);
    }


}
