package com.axa.webpage.testcase.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by kijo.kim on 8/11/14.
 */
public abstract class NaverPage {

    WebDriver driver;

    @FindBy(how = How.ID, using = "query")
    public WebElement naverSearch;

    @FindBy(how = How.ID, using = "search_btn")
    public WebElement naverSearchBtn;

    @FindBy(how = How.LINK_TEXT, using = "AXA다이렉트")
    public WebElement linkAXA;

    public NaverPage(WebDriver driver) {
        this.driver = driver;
    }


    public void openAXALink(String keyword) throws InterruptedException {
       searchAXALink(keyword);
        handleTab();
    }
    protected abstract void searchAXALink(String keyword);

    protected abstract void handleTab() throws InterruptedException;


}
