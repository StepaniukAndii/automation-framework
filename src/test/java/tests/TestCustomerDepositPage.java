package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CustomerDepositPage;
import pages.CustomerPage;

public class TestCustomerDepositPage extends TestInit{

    String message = "Deposit Successful";
    int depositSum = 100;
    int balance;

    @DataProvider(name = "CustomerName")
    public Object[][] getDataFromDataprovider() {
        return new Object[][]
                {
                        {"Ron Weasly", "1008"},
//                        {"Albus Dumbledore", "1011"},
//                        {"Neville Longbottom", "1014"}
                };
    }

    @Test(dataProvider = "CustomerName")
    public void testElementsForDepositPage(String customer, String account){
        CustomerDepositPage customerDepositPage = new CustomerDepositPage(driver);
        customerDepositPage
                .open()
                .openByUser(customer);
        Assert.assertTrue(customerDepositPage.getAmountLabelDeposit().isDisplayed());
        Assert.assertTrue(customerDepositPage.amountSelect().isDisplayed());
        Assert.assertTrue(customerDepositPage.depositBtn().isDisplayed());

    }

    @Test(dataProvider = "CustomerName")
    public void checkTheFunctionalityOfMakingDeposit(String customer, String account){


        CustomerDepositPage customerDepositPage = new CustomerDepositPage(driver);
        customerDepositPage
                .openByUser(customer)
                .setAmount(depositSum)
                .clickDepositBtn();

        Assert.assertTrue(customerDepositPage.depositMessage().isDisplayed());
        Assert.assertEquals(customerDepositPage.setDepositMessage(), message);

    }

    @Test(dataProvider = "CustomerName")
    public void checkCustomerPage(String customer, String account){

       CustomerPage customerPage = new CustomerPage(driver);
       customerPage
               .openByUser(customer)
               .selectAccount(account);

        balance = customerPage.getAccountBalance()+depositSum;

        customerPage
               .clickDepositButton()
               .setAmount(depositSum)
               .clickDepositBtn();

       Assert.assertEquals(customerPage.getAccountBalance(), balance);
    }
}
