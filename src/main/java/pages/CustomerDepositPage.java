package pages;

import basePages.AbstractBasePage;
import elements.HeaderElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomerDepositPage extends AbstractBasePage {
    protected CustomerDepositPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public CustomerDepositPage open() {
        openUrl(env + "customer");
        return this;
    }

    public HeaderElements getHeaderElements() {
        return new HeaderElements(driver);
    }

    private final static String LABEL_AMOUNT_DEPOSIT = "//label";
    private final static String AMOUNT_SELECT = "//input[@type='number']";
    private final static String DEPOSIT_BTN = "//button[@type='submit']";

    public WebElement getAmountLabelDeposit() {
        return waitVisibleOfElement(LABEL_AMOUNT_DEPOSIT);
    }

    public WebElement amountSelect() {
        return waitClickableElementByXpath(AMOUNT_SELECT);
    }

    public WebElement depositBtn() {
        return waitClickableElementByXpath(DEPOSIT_BTN);
    }

    public CustomerDepositPage setAmount(int baksu) {
        amountSelect().sendKeys(String.valueOf(baksu));
        return this;
    }

    public CustomerDepositPage clickDepositBtn() {
        depositBtn().click();
        return this;
    }
}
