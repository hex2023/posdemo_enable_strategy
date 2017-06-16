package com.axa.webpage.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class AXAServiceLinkTest {


    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        File file = new File("/Volumes/HD/work/tools/webdriver/chromedriver");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterClass
    public void afterClass(){
        driver.close();


    }
    @Test
    public void testScenario1() {

        try {
            driver.get("http://www.naver.com");
            driver.findElement(By.id("query")).click();
            driver.findElement(By.id("query")).sendKeys("AXA");
            driver.findElement(By.id("search_btn")).click();
            driver.findElement(By.linkText("AXA다이렉트")).click();


            ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
            driver.close();
            driver.switchTo().window(tab.get(1));
            driver.switchTo().frame(driver.findElement(By.name("AxaMain")));

            WebElement e1 = driver.findElement(By.linkText("보상서비스"));
            Actions actions = new Actions(driver);
            actions.moveToElement(e1).perform();

            driver.findElement(By.linkText("AXA 우수정비협력업체")).click();
            Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*강남제일모터스[\\s\\S]*$"));

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }

    }

    @Test
    public void testScenario2() {

        try {
            driver.get("http://www.naver.com");
            driver.findElement(By.id("query")).click();
            driver.findElement(By.id("query")).sendKeys("AXA");
            driver.findElement(By.id("search_btn")).click();
            driver.findElement(By.linkText("AXA다이렉트")).click();

            ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
            driver.close();
            driver.switchTo().window(tab.get(1));
            driver.switchTo().frame(driver.findElement(By.name("AxaMain")));

            WebElement e1 = driver.findElement(By.linkText("보상서비스"));
            Actions actions = new Actions(driver);
            actions.moveToElement(e1).perform();

            driver.findElement(By.linkText("전국보상망 찾기")).click();
            Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*중앙대물보상[\\s\\S]*$"));

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();

        }
    }
}