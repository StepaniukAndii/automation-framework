package pages;

import basePages.AbstractBasePage;
import elements.HeaderElements;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomerTransactions extends AbstractBasePage {

    public CustomerTransactions(WebDriver driver) {
        super(driver);
    }

    @Override
    public CustomerTransactions open() {
        openUrl(env + "listTx");
        return this;
    }

    public HeaderElements getHeaderElements() {
        return new HeaderElements(driver);
    }

    public WebElement backBtn() {
        return waitClickableElementByXpath("//button[@ng-click ='back()']");
    }

    public WebElement resetBtn() {
        return waitClickableElementByXpath("//button[@ng-click ='reset()']");
    }

    public WebElement nextPageBtn() {
        return waitClickableElementByXpath("//button[@ng-show='right']");
    }

    @Step("Click on 'Back' Btn")
    public CustomerTransactions clickBackBtn() {
        backBtn().click();
        return this;
    }

    @Step("Click on 'Reset' Btn")
    public CustomerTransactions clickResetBtn() {
        resetBtn().click();
        return this;
    }

    @Step("Click on '>' Btn")
    public CustomerTransactions clickNextPageBtn() {
        nextPageBtn().click();
        return this;
    }
}
