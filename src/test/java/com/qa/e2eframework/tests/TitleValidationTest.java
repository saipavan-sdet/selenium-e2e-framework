package com.qa.e2eframework.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.e2eframework.base.BaseTest;

public class TitleValidationTest extends BaseTest {

    @Test
    public void verifyPageTitle() {

        System.out.println("Starting Page Title Validation Test");

        String title = driver.getTitle();
        System.out.println("Captured page title: " + title);

        Assert.assertEquals(
                title,
                "The Internet",
                "Page title mismatch"
        );

        System.out.println("Page Title Validation Passed");
    }
}
