package tests;

import healper.DriverHelper;
import listener.ListenerTest;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import utils.SiteConfig;

import java.time.Duration;

@Log4j
@Listeners(ListenerTest.class)
public abstract class TestInit {

    protected WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        SiteConfig siteConfig = new SiteConfig();
        DriverHelper.setHeadless(siteConfig.getProperty("headless"));
        DriverHelper.setGrid(siteConfig.getProperty("grid"));
    }

    @BeforeMethod
    public void setUpDriver() {
        driver = DriverHelper.getDriver();
        log.info("---------- Finished set up driver --------------");
    }
    @AfterMethod
    public void quitDriver() {
        driver.quit();
        log.info("----------- Driver quit -----------");
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String getUrl(String url) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.urlContains(url));
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return driver.getCurrentUrl();
    }
}

