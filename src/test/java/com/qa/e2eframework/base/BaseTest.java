package com.qa.e2eframework.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    public WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.out.println("========== TEST STARTED ==========");
        System.out.println("Setting up Chrome browser");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        System.out.println("Browser launched and maximized");
        
     // Implicit wait for element synchronization
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("Implicit wait set to 10 seconds");

        driver.get("https://the-internet.herokuapp.com/login");
        System.out.println("Navigated to Login Page");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Closing browser");
        driver.quit();
        System.out.println("========== TEST ENDED ==========\n");
    }
}
