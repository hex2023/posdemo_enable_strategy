package com.axa.webpage.testcase.page;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

/**
 * Created by kijo.kim on 8/12/14.
 */
public class NaverPageForDesktop extends NaverPage {
    public NaverPageForDesktop(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void searchAXALink(String keyword) {
        naverSearch.click();
        naverSearch.sendKeys(keyword);
        naverSearchBtn.click();
        linkAXA.click();
    }

    @Override
    protected void handleTab() throws InterruptedException {
        ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
        driver.close();
        Thread.sleep(1000);
        driver.switchTo().window(tab.get(1));

    }


}
