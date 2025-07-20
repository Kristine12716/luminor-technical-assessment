package com.imdb.config;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;

import java.util.List;
import java.util.Map;

public class TestConfig {
    
    @BeforeSuite
    public void setUpSuite() {
        // Browser configuration
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        Configuration.headless = Boolean.parseBoolean(System.getProperty("headless", "false"));
        Configuration.timeout = 10000;
        Configuration.pageLoadTimeout = 30000;
        
        // Chrome options to bypass bot detection
        Configuration.browserCapabilities.setCapability("goog:chromeOptions", Map.of(
            "args", List.of(
                "--user-agent=Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/138.0.0.0 Safari/537.36",
                "--disable-blink-features=AutomationControlled",
                "--disable-dev-shm-usage",
                "--no-sandbox",
                "--disable-gpu"
            )
        ));
        
        // Screenshot configuration
        Configuration.screenshots = true;
        Configuration.savePageSource = true;
        Configuration.reportsFolder = "build/reports/selenide";
    }
} 