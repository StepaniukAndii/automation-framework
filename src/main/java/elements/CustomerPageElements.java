package elements;

import BasePages.AbstractBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomerPageElements extends AbstractBasePage {
    public CustomerPageElements(WebDriver driver) {
        super(driver);
    }

    @Override
    public CustomerPageElements open() {
        openUrl("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/customer");
        return this;
    }

    private final static String HOME_BTN = "//button[@class='btn home']";
    private final static String YOUR_NAME_FIELD = "//select[@class]";
    private final static String HEADER_FILED = "//strong[@class]";
    private final static String USER_HERMIONE_GRANGER = "//option[@value='1']";
    private final static String USER_HARRY_POTTER = "//option[@value='2']";
    private final static String USER_RON_WEASLY = "//option[@value='3']";
    private final static String USER_ALBUS_DUMBLEDORE = "//option[@value='4']";
    private final static String USER_NEVILLE_LONGBOTTOM = "//option[@value='5']";
    private final static String LOGIN_BTN = "//*[contains(text(), 'Login')]";

    public WebElement getHomeBtn() {
        return waitClickableElementByXpath(HOME_BTN);
    }

    public WebElement getYourNameField() {
        return waitClickableElementByXpath(YOUR_NAME_FIELD);
    }

    public WebElement getHeader() {
        return waitVisibleOfElement(HEADER_FILED);

    }

    public WebElement getUserOne() {
        return waitClickableElementByXpath(USER_HERMIONE_GRANGER);
    }

    public WebElement getUserTwo() {
        return waitClickableElementByXpath(USER_HARRY_POTTER);
    }

    public WebElement getUserThree() {
        return waitClickableElementByXpath(USER_RON_WEASLY);
    }

    public WebElement getUserFour() {
        return waitClickableElementByXpath(USER_ALBUS_DUMBLEDORE);
    }

    public WebElement getUserFive() {
        return waitClickableElementByXpath(USER_NEVILLE_LONGBOTTOM);
    }

    public WebElement getLoginBtn() {
        return waitClickableElementByXpath(LOGIN_BTN);
    }

}
