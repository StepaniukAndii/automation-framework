package tests;

import PageObject.HomePage;
import jdk.jfr.Timespan;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestHomePage extends TestInit {

    @Test
    public void checkTitle() {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        Assert.assertEquals(driver.getTitle(), "XYZ Bank");
    }

    @Test
    public void checkCustomerLoginBtn1() {
        new HomePage(driver)
                .open()
                .clickCustomerLoginBtn()
                .select().isDisplayed();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/customer");
    }

    @Test
    public void checkBankManagerLoginBtn1() {
        new HomePage(driver)
                .open()
                .clickBankManagerLoginBtn()
                .addCustomerPage().isDisplayed();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager");

    }
}



