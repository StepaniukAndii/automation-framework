package tests;

import healper.DriverHelper;
import lombok.extern.log4j.Log4j;
import org.bouncycastle.jcajce.provider.symmetric.SEED;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.SiteConfig;

import java.util.concurrent.TimeUnit;

@Log4j
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
}

