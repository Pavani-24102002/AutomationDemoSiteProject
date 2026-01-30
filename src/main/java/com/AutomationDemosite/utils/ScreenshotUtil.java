package com.AutomationDemosite.utils;

import org.apache.logging.log4j.Logger;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {
    private static final Logger log = LoggerUtil.getLogger(ScreenshotUtil.class);

    public static void captureScreenshot(WebDriver driver, String fileName) {
        log.info("Capturing screenshot: {}", fileName);
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File dest = new File("screenshots/" + fileName + "__" + timestamp + ".png");
        try {
            Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
            log.info("Screenshot saved: {}", dest.getAbsolutePath());
        } catch (IOException e) {
            log.error("Error saving screenshot", e);
        }
    }
}




