package com.axa.webpage.testcase.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by kijo.kim on 8/11/14.
 */
public class AXAMenuPageForDesktop extends AXAMenuPage{

    @FindBy(how = How.NAME, using = "AxaMain")
    public WebElement axaMain;

    @FindBy(how = How.LINK_TEXT, using = "보상서비스")
    public WebElement compensationService;

    @FindBy(how = How.LINK_TEXT, using = "AXA 우수정비협력업체")
    public WebElement excellenceCoperate;

    @FindBy(how = How.LINK_TEXT, using = "전국보상망 찾기")
    public WebElement searchCoperate;

    public AXAMenuPageForDesktop(WebDriver driver) {
        super(driver);
    }

    @Override
    public void navigateMenu(){
        driver.switchTo().frame(axaMain);
        Actions actions = new Actions(driver);
        actions.moveToElement(compensationService).perform();
    }

}
