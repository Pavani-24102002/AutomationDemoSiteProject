package com.AutomationDemosite.utils;

import org.apache.logging.log4j.Logger;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties prop;
    private static final Logger log = LoggerUtil.getLogger(ConfigReader.class);

    public static Properties initProperties() {
        prop = new Properties();
        try {
            FileInputStream ip = new FileInputStream("src/main/resources/config.properties");
            prop.load(ip);
            log.info("Configuration loaded successfully");
        } catch (IOException e) {
            log.error("Error loading configuration file", e);
        }
        return prop;
    }
}






