package com.accenture.mobility.swv;

import com.accenture.mobility.swv.annotation.EnableSikuliConfig;
import org.sikuli.script.App;
import org.sikuli.script.Screen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterTest;

@EnableSikuliConfig
public class SikuliTestSupport extends AbstractTestNGSpringContextTests {

    @Autowired
    public Screen screen;

    @Autowired
    public Environment env;

    @Autowired
    public App app;


    @AfterTest
    public void after() {

        if (app != null) {
            app.close();
        }
    }

}
