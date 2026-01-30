package com.AutomationDemosite.tests;

import com.AutomationDemosite.base.BaseTest;
import com.AutomationDemosite.pages.AlertsPage;
import com.AutomationDemosite.utils.ExcelUtil;
import com.AutomationDemosite.utils.LoggerUtil;
import com.AutomationDemosite.utils.ScreenshotUtil;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AlertTestng extends BaseTest {
    AlertsPage alertsPage;
    private static final Logger log = LoggerUtil.getLogger(AlertTestng.class);

    @BeforeClass
    public void setUpTest() {
        log.info("Setting up AlertTestng...");
        setup();
        alertsPage = new AlertsPage(driver);
    }

    @Test(priority = 1)
    public void testOkAlert() {
        log.info("Starting OK Alert test");
        alertsPage.clickAlertOkTab();
        alertsPage.clickOkButton();
        Alert okAlert = wait.until(ExpectedConditions.alertIsPresent());
        String text = okAlert.getText();
        log.info("OK Alert text captured: {}", text);
        ExcelUtil.writeResult("OK Alert", text);

        Assert.assertEquals(text, "I am an alert box!", "OK Alert text mismatch!");
        okAlert.accept();
        log.info("OK Alert accepted");
        ScreenshotUtil.captureScreenshot(driver, "ok_alert");
    }

    @Test(priority = 2)
    public void testConfirmAlert() {
        log.info("Starting Confirm Alert test");
        alertsPage.clickConfirmTab();
        alertsPage.clickConfirmButton();
        Alert confirmAlert = wait.until(ExpectedConditions.alertIsPresent());
        String text = confirmAlert.getText();
        log.info("Confirm Alert text captured: {}", text);
        ExcelUtil.writeResult("Confirm Alert", text);

        Assert.assertEquals(text, "Press a Button !", "Confirm Alert text mismatch!");
        confirmAlert.dismiss();
        log.info("Confirm Alert dismissed");
        String msg = alertsPage.getConfirmMsg();
        log.info("Confirm message captured: {}", msg);
        ExcelUtil.writeResult("Confirm Message", msg);

        Assert.assertEquals(msg, "You Pressed Cancel", "Confirm message mismatch!");
        ScreenshotUtil.captureScreenshot(driver, "confirm_msg");
    }

    @Test(priority = 3)
    public void testPromptAlert() {
        log.info("Starting Prompt Alert test");
        alertsPage.clickPromptTab();
        alertsPage.clickPromptButton();
        Alert promptAlert = wait.until(ExpectedConditions.alertIsPresent());
        String name = prop.getProperty("name");
        log.info("Entering name into Prompt Alert: {}", name);
        promptAlert.sendKeys(name);
        promptAlert.accept();
        log.info("Prompt Alert accepted");
        String msg = alertsPage.getPromptMsg();
        log.info("Prompt message captured: {}", msg);
        ExcelUtil.writeResult("Prompt Message", msg);

        Assert.assertTrue(msg.contains(name), "Prompt message does not contain the expected name!");
        ScreenshotUtil.captureScreenshot(driver, "promptmsg");
    }

    @AfterClass
    public void tearDownTest() {
        log.info("Tearing down AlertTestng...");
        ExcelUtil.saveExcel(prop);
        tearDown();
    }
}





