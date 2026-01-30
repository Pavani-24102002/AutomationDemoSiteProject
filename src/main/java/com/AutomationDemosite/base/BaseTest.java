package com.AutomationDemosite.base;

import com.AutomationDemosite.utils.ConfigReader;
import com.AutomationDemosite.utils.DriverFactory;
import com.AutomationDemosite.utils.LoggerUtil;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Properties prop;
    private static final Logger log = LoggerUtil.getLogger(BaseTest.class);

    public void setup() {
        log.info("Initializing test setup...");
        prop = ConfigReader.initProperties();
        String browser = prop.getProperty("browser", "chrome");
        driver = DriverFactory.initDriver(browser);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(prop.getProperty("url"));
        log.info("Navigated to URL: {}", prop.getProperty("url"));
    }

    public void tearDown() {
        log.info("Closing browser...");
        DriverFactory.quitDriver();
    }
}






