package org.tutorialsninjaRegister;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_register_019 {

    WebDriver driver;

    @Test
    public void verifyLeadingandTrailingSpaces(){

        WebDriverClass webDriverClass = new WebDriverClass();
        driver = webDriverClass.driveMethod();

        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();

        String enteredFirst = "          Smita     ";
                driver.findElement(By.id("input-firstname")).sendKeys(enteredFirst);
        String enteredLast ="    Bidwai    ";
            driver.findElement(By.id("input-lastname")).sendKeys(enteredLast);
        String enteredEmail ="            smhitddffaakddfa@gmail.com   ";
            driver.findElement(By.id("input-email")).sendKeys(enteredEmail);
        String enteredPhNo = "     913025235   ";
            driver.findElement(By.id("input-telephone")).sendKeys(enteredPhNo);

        driver.findElement(By.id("input-password")).sendKeys("12345");
        driver.findElement(By.id("input-confirm")).sendKeys("12345");
        driver.findElement(By.name("agree")).click();
        driver.findElement(By.xpath("//input[@value ='Continue']")).click();

        driver.findElement(By.linkText("Continue")).click();
        driver.findElement(By.linkText("Edit your account information")).click();
        String actualEmail = driver.findElement(By.id("input-email")).getAttribute("value");
//        verify email
        System.out.println(actualEmail);
        Assert.assertEquals(actualEmail,enteredEmail.trim());
//        verify firstname
        Assert.assertEquals(driver.findElement(By.id("input-firstname")).getAttribute("value"),enteredFirst.trim());
//        verify lastname
        Assert.assertEquals(driver.findElement(By.id("input-lastname")).getAttribute("value"),enteredLast.trim());
//        verify phone number
        Assert.assertEquals(driver.findElement(By.id("input-telephone")).getAttribute("value"),enteredPhNo.trim());
        driver.quit();
    }
}
