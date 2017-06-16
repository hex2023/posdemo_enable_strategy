package com.axa.webpage.testcase.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by kijo.kim on 8/11/14.
 */
public class AXAMenuPageForMobile extends AXAMenuPage {


    @FindBy(how = How.XPATH, using = "//*[@id=\"header\"]/div[1]/p[4]")
    public WebElement mobileMenuCategory;

    @FindBy(how = How.LINK_TEXT, using = "자동차보상")
    public WebElement mobileMenuCompensation;

    @FindBy(how = How.LINK_TEXT, using = "긴급출동 서비스안내")
    public WebElement mobileMenuEmergencyService;

    public AXAMenuPageForMobile(WebDriver driver) {
        super(driver);
    }


    @Override
    public void navigateMenu() throws InterruptedException {
        mobileMenuCategory.click();
        Thread.sleep(1000);

    }
}
