package com.imdb.base;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {
    
    @BeforeMethod
    public void setUp() {
        // Common setup for each test method
        Selenide.open();
    }
    
    @AfterMethod
    public void tearDown(ITestResult result) {
        // Take screenshot on test failure
        if (result.getStatus() == ITestResult.FAILURE) {
            takeScreenshot();
        }
        
        // Close browser after each test
        Selenide.closeWebDriver();
    }
    
    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] takeScreenshot() {
        if (WebDriverRunner.hasWebDriverStarted()) {
            return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
        }
        return new byte[0];
    }
} 