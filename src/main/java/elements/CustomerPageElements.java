package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import basePages.AbstractBasePage;

public class CustomerPageElements extends AbstractBasePage {
    protected CustomerPageElements(WebDriver driver) {
        super(driver);
    }
    private final static String TRANS_BUTT = "//button[@ng-class='btnClass1']";
    private final static String DEP_BUTT = "//button[@ng-class='btnClass2']";
    private final static String WITH_BUTT = "//button[@ng-class='btnClass3']";
    private final static String LOGOUT_BUTT = "//button[@class='logout']";
    private final static String NAME = "/html/body/div/div/div[2]/div/div[1]/strong/span";
    private final static String ACC_NUM = "/html/body/div/div/div[2]/div/div[2]/strong[1]";
    private final static String ACC_BAL = "/html/body/div/div/div[2]/div/div[2]/strong[2]";
    private final static String ACC_CUR = "/html/body/div/div/div[2]/div/div[2]/strong[3]";
    private final static String ACC_SEL = "//select[@id='accountSelect']";
    
    @Override
    public CustomerPageElements open() {
        openUrl("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/account");
        return this;
    }
    public WebElement TransactionButton() {
        return waitClickableElementByXpath(TRANS_BUTT);
    }
    public WebElement DepositButton() {
        return waitClickableElementByXpath(DEP_BUTT);
    }
    public WebElement WithdrawButton() {
        return waitClickableElementByXpath(WITH_BUTT);
    }
    public WebElement LogoutButton() {
        return waitClickableElementByXpath(LOGOUT_BUTT);
    }
    public WebElement Name() {
        return waitClickableElementByXpath(NAME);
    }
    public WebElement AccountNumber() {
        return waitClickableElementByXpath(ACC_NUM);
    }
    public WebElement AccountBalance() {
        return waitClickableElementByXpath(ACC_BAL);
    }
    public WebElement AccountCurrency() {
        return waitClickableElementByXpath(ACC_CUR);
    }
    public Select AccountSelectField() {
        return (Select)waitClickableElementByXpath(ACC_SEL);
    }
}
