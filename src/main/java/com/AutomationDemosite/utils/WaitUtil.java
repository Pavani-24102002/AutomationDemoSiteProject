package com.AutomationDemosite.utils;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WaitUtil {
    private WebDriver driver;
    private WebDriverWait wait;
    private static final Logger log = LoggerUtil.getLogger(WaitUtil.class);

    public WaitUtil(WebDriver driver, int timeoutSeconds) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        log.info("WaitUtil initialized with timeout: {} seconds", timeoutSeconds);
    }

    public Alert waitForAlert() {
        log.info("Waiting for alert to be present...");
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    public WebElement waitForVisibility(WebElement element) {
        log.info("Waiting for element visibility: {}", element);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForClickable(WebElement element) {
        log.info("Waiting for element to be clickable: {}", element);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public boolean waitForTitle(String titleFragment) {
        log.info("Waiting for title to contain: {}", titleFragment);
        return wait.until(ExpectedConditions.titleContains(titleFragment));
    }

    public boolean waitForText(WebElement element, String text) {
        log.info("Waiting for text '{}' to be present in element: {}", text, element);
        return wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }
}


