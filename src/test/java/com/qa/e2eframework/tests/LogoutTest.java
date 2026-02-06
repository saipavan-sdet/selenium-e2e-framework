package com.qa.e2eframework.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.e2eframework.base.BaseTest;

public class LogoutTest extends BaseTest {

    @Test
    public void logoutTest() {

        System.out.println("Starting Logout Test");

        driver.findElement(By.id("username")).sendKeys("tomsmith");
        System.out.println("Entered username");

        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        System.out.println("Entered password");

        driver.findElement(By.cssSelector("button[type='submit']")).click();
        System.out.println("Logged into application");

        driver.findElement(By.cssSelector("a.button.secondary.radius")).click();
        System.out.println("Clicked Logout button");

        String logoutMsg = driver.findElement(By.id("flash")).getText();
        System.out.println("Logout message captured: " + logoutMsg);

        Assert.assertTrue(
                logoutMsg.contains("You logged out of the secure area"),
                "Logout failed"
        );

        System.out.println("Logout Test Passed");
    }
}
