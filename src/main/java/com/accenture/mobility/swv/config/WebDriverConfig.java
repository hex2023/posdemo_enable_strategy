package com.accenture.mobility.swv.config;

import com.accenture.mobility.swv.WebDriverTestSupport;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.sikuli.script.App;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.MessageFormat;

@Configuration
@Import(value = SWVConfig.class)
public class WebDriverConfig {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(WebDriverConfig.class);


    @Autowired
    private ApplicationContext context;

    @Autowired
    SWVConfig swvConfig;

    @Autowired
    public Environment env;

    @Bean(name = "chromeDriver")
    public WebDriver chromeDriver() throws Exception {
        System.setProperty("webdriver.chrome.driver", new File(getWebDriverChromePath()).getAbsolutePath());
        return new ChromeDriver();
    }

    @Bean(name = "firefoxDriver")
    public WebDriver firefoxDriver() throws Exception {
        return new FirefoxDriver();
    }

    public WebDriver webDriver() throws Exception {

        WebDriver driver = null;
        File driverFile = null;
        String browserType = null;
        if (browserType.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();

        } else if (browserType.equalsIgnoreCase("ie")) {
            driverFile = new File(env.getProperty("webdriver.ie.win.path"));
            System.setProperty("webdriver.ie.driver", driverFile.getAbsolutePath());
            driver = new InternetExplorerDriver();

        } else if (browserType.equalsIgnoreCase("chrome")) {
            driverFile = new File(getWebDriverChromePath());
            System.setProperty("webdriver.chrome.driver", driverFile.getAbsolutePath());
            driver = new ChromeDriver();
        } else if (browserType.equalsIgnoreCase("ios")) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("deviceName", "iPhone Simulator");
//            capabilities.setCapability("deviceName", "iPhone");
            capabilities.setCapability("platformName", "iOS");
            capabilities.setCapability("platformVersion", "7.1");
            capabilities.setCapability(CapabilityType.BROWSER_NAME, "safari");
            driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"),
                    capabilities);

        } else if (browserType.equalsIgnoreCase("android")) {
            //TODO: need to set android chrome....Webdriver setting.... with appium

        } else if (browserType.equalsIgnoreCase("sauceLab")) {
            String sauceUserName = "hex2023";
            String sauceAccessKey = "abd03339-3211-4407-93be-98b70f3272bb";
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("deviceName", "iPhone Simulator");
            capabilities.setCapability("platformName", "iOS");
            capabilities.setCapability("platformVersion", "7.1");
//            capabilities.setCapability(CapabilityType.BROWSER_NAME, "safari");
            capabilities.setCapability("app", "safari");
            driver = new RemoteWebDriver(new URL(MessageFormat.format("http://{0}:{1}@ondemand.saucelabs.com:80/wd/hub", sauceUserName, sauceAccessKey)),
                    capabilities);
        }
        return driver;

    }

    protected String getWebDriverChromePath() throws Exception {
        String retPath = null;
        if (swvConfig.getOsType().contains("win")) {
            retPath = env.getProperty("webdriver.chrome.win.path");
        } else if (swvConfig.getOsType().contains("mac")) {
            retPath = env.getProperty("webdriver.chrome.mac.path");
        } else if (swvConfig.getOsType().contains("nix") || swvConfig.getOsType().contains("nux") || swvConfig.getOsType().contains("aix")) {
            retPath = env.getProperty("webdriver.chrome.linux.path");
        } else if (swvConfig.getOsType().contains("sunos")) {
            retPath = env.getProperty("webdriver.chrome.sunos.path");
        }
        if (retPath == null) {
            throw new Exception("chrome webDriver is not detected!!");
        }
        return retPath;
    }


}
