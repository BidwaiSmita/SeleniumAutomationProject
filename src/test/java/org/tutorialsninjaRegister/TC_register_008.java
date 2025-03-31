package org.tutorialsninjaRegister;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_register_008 {

    WebDriver driver8;
    @Test
    public void verifyPasswordCorrectORNot(){

        WebDriverClass webDriverClass = new WebDriverClass();
        driver8 = webDriverClass.driveMethod();
        TC_register_001 tc_register_001 = new TC_register_001();

        driver8.findElement(By.xpath("//span[text()='My Account']")).click();
        driver8.findElement(By.linkText("Register")).click();
        driver8.findElement(By.id("input-firstname")).sendKeys("Smita");
        driver8.findElement(By.id("input-lastname")).sendKeys("Bidwai");
        driver8.findElement(By.id("input-email")).sendKeys(tc_register_001.GenerateEmail());
        driver8.findElement(By.id("input-telephone")).sendKeys("913025235");
        driver8.findElement(By.id("input-password")).sendKeys("12345");
        driver8.findElement(By.id("input-confirm")).sendKeys("1234567");
        driver8.findElement(By.name("agree")).click();
        driver8.findElement(By.xpath("//input[@value ='Continue']")).click();

        String ExpectedMessage = "Password confirmation does not match password!";

        Assert.assertEquals(ExpectedMessage, driver8.findElement(By.xpath("//input[@id='input-confirm']/following-sibling::div")).getText());

//        driver8.quit();

    }
}
