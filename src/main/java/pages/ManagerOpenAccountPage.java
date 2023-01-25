package pages;

import basePages.AbstractBasePage;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
@Log4j
public class ManagerOpenAccountPage extends AbstractBasePage {


    public ManagerOpenAccountPage(WebDriver driver) {
        super(driver);
    }

    private final static String SELECT_CUSTOMER = "//select[@name='userSelect']";
    private final static String SELECT_CURRENCY = "//select[@name='currency']";
    private final static String PROGRESS_BUTTON = "//button[text()='Process']";

    @Override
    public ManagerOpenAccountPage open() {
        openUrl(env + "manager/openAccount");
        return this;
    }

    @Step("Select account {0}")
    public ManagerOpenAccountPage selectCustomer(String account) {
        new Select(waitVisibleOfElement(SELECT_CUSTOMER)).selectByVisibleText(account);
        return this;
    }

    @Step("Select currency {1}")
    public ManagerOpenAccountPage selectCurrency(String currency) {
        new Select(waitVisibleOfElement(SELECT_CURRENCY)).selectByVisibleText(currency);
        return this;
    }

    public WebElement progressBtn() {
        return waitClickableElementByXpath(PROGRESS_BUTTON);
    }

    //HELP METHODS

    public ManagerOpenAccountPage clickProgressBtn() {
        log.info("---------------------click Progress Button---------------------");
        progressBtn().click();
        return this;

    }

    public String alertMessagePrint() {
        log.info("---------------------alert message---------------------");
        return driver.switchTo().alert().getText().split(":")[1];

    }

}