package com.qa.e2eframework.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.e2eframework.base.BaseTest;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {

        System.out.println("Starting Valid Login Test...");

        driver.findElement(By.id("username")).sendKeys("tomsmith");
        System.out.println("Entered valid username");

        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        System.out.println("Entered valid password");

        driver.findElement(By.cssSelector("button[type='submit']")).click();
        System.out.println("Clicked Login button");

        String successMsg = driver.findElement(By.id("flash")).getText();
        System.out.println("Login success message captured: " + successMsg);

        Assert.assertTrue(
                successMsg.contains("You logged into a secure area"),
                "Login failed!"
        );

        System.out.println("Valid Login Test Passed");
    }
}
