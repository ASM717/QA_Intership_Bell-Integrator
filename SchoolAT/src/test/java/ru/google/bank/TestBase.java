package ru.google.bank;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverInfo;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver webDriver;

    @BeforeEach
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //wait = new WebDriverWait(webDriver, 30, 500);
    }

    @AfterEach
    public void afterTest() {
        webDriver.quit();
    }

}
