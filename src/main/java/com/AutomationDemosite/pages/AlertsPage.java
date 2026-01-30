package com.AutomationDemosite.pages;

import com.AutomationDemosite.utils.LoggerUtil;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsPage {
    WebDriver driver;
    private static final Logger log = LoggerUtil.getLogger(AlertsPage.class);

    public AlertsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[href='#OKTab']")
    WebElement alertOkTab;

    @FindBy(css = "button[onclick='alertbox()']")
    WebElement okButton;

    @FindBy(css = "a[href='#CancelTab']")
    WebElement confirmTab;

    @FindBy(css = "button[onclick='confirmbox()']")
    WebElement confirmButton;

    @FindBy(css = "#demo")
    WebElement confirmMsg;

    @FindBy(css = "a[href='#Textbox']")
    WebElement promptTab;

    @FindBy(css = "button[onclick='promptbox()']")
    WebElement promptButton;

    @FindBy(css = "#demo1")
    WebElement promptMsg;

    public void clickAlertOkTab() { log.info("Clicking OK Tab"); alertOkTab.click(); }
    public void clickOkButton() { log.info("Clicking OK Button"); okButton.click(); }
    public void clickConfirmTab() { log.info("Clicking Confirm Tab"); confirmTab.click(); }
    public void clickConfirmButton() { log.info("Clicking Confirm Button"); confirmButton.click(); }
    public String getConfirmMsg() { String msg = confirmMsg.getText().trim(); log.info("Confirm message: {}", msg); return msg; }
    public void clickPromptTab() { log.info("Clicking Prompt Tab"); promptTab.click(); }
    public void clickPromptButton() { log.info("Clicking Prompt Button"); promptButton.click(); }
    public String getPromptMsg() { String msg = promptMsg.getText().trim(); log.info("Prompt message: {}", msg); return msg; }
}







