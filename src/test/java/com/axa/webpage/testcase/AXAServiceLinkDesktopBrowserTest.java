package com.axa.webpage.testcase;

import com.accenture.mobility.swv.WebDriverTestSupport;
import com.axa.webpage.testcase.page.AXAMenuPage;
import com.axa.webpage.testcase.page.AXAMenuPageForDesktop;
import com.axa.webpage.testcase.page.NaverPage;
import com.axa.webpage.testcase.page.NaverPageForDesktop;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class AXAServiceLinkDesktopBrowserTest extends WebDriverTestSupport {

    NaverPageForDesktop naverPage;
    AXAMenuPageForDesktop axaMenuPage;

    @BeforeMethod
    public void beforeMethod() {
        driver.get("http://www.naver.com");
        naverPage = PageFactory.initElements(driver, NaverPageForDesktop.class);
        axaMenuPage = PageFactory.initElements(driver, AXAMenuPageForDesktop.class);

    }

    @Test(enabled =true)
    public void testScenario1() {
        try {
            naverPage.openAXALink("AXA");
            axaMenuPage.navigateMenu();

            axaMenuPage.excellenceCoperate.click();
            Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*강남제일모터스[\\s\\S]*$"));

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }

    }

    @Test(enabled = true)
    public void testScenario2() {
        try {
            naverPage.openAXALink("AXA");
            axaMenuPage.navigateMenu();

            axaMenuPage.searchCoperate.click();
            Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*중앙대물보상[\\s\\S]*$"));

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();

        }
    }

}