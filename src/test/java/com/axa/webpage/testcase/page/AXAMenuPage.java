package com.axa.webpage.testcase.page;

import org.openqa.selenium.WebDriver;

/**
 * Created by kijo.kim on 8/11/14.
 */
public abstract class AXAMenuPage {

    WebDriver driver;

    public AXAMenuPage(WebDriver driver) {
        this.driver = driver;
    }
    public abstract void navigateMenu() throws InterruptedException;

}
