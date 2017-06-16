package com.axa.webpage.testcase;

import com.accenture.mobility.swv.WebDriverTestSupport;
import com.axa.webpage.testcase.page.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class AXAServiceLinkMobileBrowserTest extends WebDriverTestSupport {

    NaverPageForMobile naverPage;
    AXAMenuPageForMobile axaMenuPage;

    @BeforeMethod
    public void beforeMethod() {
        driver.get("http://m.naver.com");
        naverPage = PageFactory.initElements(driver, NaverPageForMobile.class);
        axaMenuPage = PageFactory.initElements(driver, AXAMenuPageForMobile.class);

    }

    @Test
    public void testScenario3() {
        try {
            naverPage.openAXALink("AXA");
            axaMenuPage.navigateMenu();
            axaMenuPage.mobileMenuCompensation.click();
            axaMenuPage.mobileMenuEmergencyService.click();
            Assert.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*긴급견인 서비스[\\s\\S]*$"));


        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();

        }
    }

}