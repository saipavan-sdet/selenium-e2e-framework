package com.qa.e2eframework.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.e2eframework.base.BaseTest;

public class InvalidLoginTest extends BaseTest {

    @Test
    public void invalidLoginTest() {

        System.out.println("Starting Invalid Login Test");

        driver.findElement(By.id("username")).sendKeys("wronguser");
        System.out.println("Entered invalid username");

        driver.findElement(By.id("password")).sendKeys("wrongpassword");
        System.out.println("Entered invalid password");

        driver.findElement(By.cssSelector("button[type='submit']")).click();
        System.out.println("Clicked Login button");

        String errorMsg = driver.findElement(By.id("flash")).getText();
        System.out.println("Error message captured: " + errorMsg);

        Assert.assertTrue(
                errorMsg.contains("Your username is invalid"),
                "Error message not displayed"
        );

        System.out.println("Invalid Login Test Passed");
    }
}
