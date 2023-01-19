package elements;

import basePages.AbstractBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HeaderElements extends AbstractBasePage {
    public HeaderElements(WebDriver driver) {
        super(driver);
    }

    @Override
    public HeaderElements open() {
        openUrl(env);
        return this;
    }

    private final static String HOME_BTN = "//button[@class='btn home']";
    private final static String XYZ_BANK = "//strong[text() = 'XYZ Bank']";

    public WebElement getHomeBtn() {
        return waitClickableElementByXpath(HOME_BTN);
    }

    public WebElement getHeader() {
        return waitVisibleOfElement(XYZ_BANK);
    }
}
