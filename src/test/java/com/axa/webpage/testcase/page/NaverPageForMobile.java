package com.axa.webpage.testcase.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.ArrayList;

/**
 * Created by kijo.kim on 8/12/14.
 */
public class NaverPageForMobile extends NaverPage {
    public NaverPageForMobile(WebDriver driver) {
        super(driver);
    }


    @FindBy(how = How.XPATH, using = "//*[@id=\"search\"]/button")
    public WebElement naverSearchBtn;


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
        Thread.sleep(1000);
        driver.switchTo().window(tab.get(0));
    }

}
