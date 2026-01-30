
package com.AutomationDemosite.utils;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactory {
    private static WebDriver driver;
    private static final Logger log = LoggerUtil.getLogger(DriverFactory.class);

    public static WebDriver initDriver(String browser) {
        log.info("Initializing driver for browser: {}", browser);
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        log.info("Driver initialized and window maximized");
        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            log.info("Quitting driver...");
            driver.quit();
            driver = null;
        }
    }
}








