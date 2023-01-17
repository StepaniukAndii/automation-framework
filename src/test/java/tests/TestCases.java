package Listener_Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Listener_Demo.ListenerTest.class)

public class TestCases {
    WebDriver driver= new ChromeDriver();

    //Test to pass as to verify listeners.
    @Test
    public void Login()
    {
        Assert.assertTrue(true);



    }

    //Forcefully failed this test as verify listener.
    @Test
    public void TestToFail()
    {
        Assert.assertTrue(false);
    }
}