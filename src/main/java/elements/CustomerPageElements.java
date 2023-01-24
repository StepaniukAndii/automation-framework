package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import basePages.AbstractBasePage;
import pages.HomePage;

public abstract class CustomerPageElements extends AbstractBasePage {
    protected CustomerPageElements(WebDriver driver) {
        super(driver);
    }

    private final static String TRANS_BUTT = "//button[@ng-class='btnClass1']";
    private final static String DEP_BUTT = "//button[@ng-class='btnClass2']";
    private final static String WITH_BUTT = "//button[@ng-class='btnClass3']";
    private final static String LOGOUT_BUTT = "//button[@class='logout']";
    private final static String NAME = "//span[contains(@class, 'fontBig ng-binding')]";
    private final static String ACC_NUM = "//div[contains(@class, 'center')]/strong[position()=1]";
    private final static String ACC_BAL = "//div[contains(@class, 'center')]/strong[position()=2]";
    private final static String ACC_CUR = "//div[contains(@class, 'center')]/strong[position()=3]";
    private final static String ACC_SEL = "//select[@id='accountSelect']";


    public WebElement transactionButton() {
        return waitClickableElementByXpath(TRANS_BUTT);
    }

    public WebElement depositButton() {
        return waitClickableElementByXpath(DEP_BUTT);
    }

    public WebElement withdrawButton() {
        return waitClickableElementByXpath(WITH_BUTT);
    }

    public WebElement logoutButton() {
        return waitClickableElementByXpath(LOGOUT_BUTT);
    }

    public WebElement name() {
        return waitClickableElementByXpath(NAME);
    }

    public WebElement accountNumber() {
        return waitClickableElementByXpath(ACC_NUM);
    }

    public WebElement accountBalance() {
        return waitClickableElementByXpath(ACC_BAL);
    }

    public WebElement accountCurrency() {
        return waitClickableElementByXpath(ACC_CUR);
    }

    public Select accountSelectField() {
        return (Select) waitClickableElementByXpath(ACC_SEL);
    }
}
