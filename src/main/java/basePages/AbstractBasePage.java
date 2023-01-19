package basePages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class AbstractBasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected JavascriptExecutor jse;
    protected Actions actions;
    public final String env = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login";

    protected void scrollToElement(WebElement element) {
        //Via Js executor
        jse.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    protected AbstractBasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        actions = new Actions(driver);
        jse = (JavascriptExecutor) driver;
    }

    protected void clickWithJS(WebElement field) {
        jse.executeScript("arguments[0].click();", field);
    }

    protected void sendText(WebElement toSendText, String text) {
        toSendText.sendKeys(text);
    }

    protected WebElement waitToAppear(WebElement webElement) {
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    protected WebElement waitVisibleOfElement(String locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    protected WebElement waitClickableElementByXpath(String locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
    }

    protected WebElement waitPresenceOfElementLocated(String locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    public WebElement $x(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    public List<WebElement> $$x(String xpath) {
        return driver.findElements(By.xpath(xpath));
    }

    public abstract <T> T open();

    @Step("Open url {0}")
    protected void openUrl(String url) {
        if (!driver.getCurrentUrl().equals(url)) {
            driver.get(url);
        }
    }
}
