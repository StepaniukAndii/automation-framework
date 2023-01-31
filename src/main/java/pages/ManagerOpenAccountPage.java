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
    public String currencyNumber;

    @Override
    public ManagerOpenAccountPage open() {
        openUrl(env + "manager/openAccount");
        return this;
    }

    @Step("Select customer")
    public ManagerOpenAccountPage selectCustomer(String account) {
        log.info("---------------------Select customer---------------------");
        new Select(waitVisibleOfElement(SELECT_CUSTOMER)).selectByVisibleText(account);
        return this;
    }

    @Step("Select currency")
    public ManagerOpenAccountPage selectCurrency(String currency) {
        log.info("---------------------Select currency---------------------");
        new Select(waitVisibleOfElement(SELECT_CURRENCY)).selectByVisibleText(currency);
        return this;
    }

    public WebElement progressBtn() {
        return waitClickableElementByXpath(PROGRESS_BUTTON);
    }

    //HELP METHODS

    @Step("Click on Progress button")
    public ManagerOpenAccountPage clickProgressBtn() {
        log.info("---------------------click Progress Button---------------------");
        progressBtn().click();
        return this;
    }

    @Step("Close alert message")
    public ManagerOpenAccountPage alertMessage() {
        log.info("---------------------alert message---------------------");
        currencyNumber = driver.switchTo().alert().getText().split(":")[1];
        log.info("---------------------Close alert message---------------------");
        driver.switchTo().alert().accept();
        return new ManagerOpenAccountPage(driver);
    }

    public ManageLoginPage openAccount(String customer, String currency){
        selectCustomer(customer);
        selectCurrency(currency);
        clickProgressBtn();
        alertMessage();
        return new ManageLoginPage(driver);
    }

}