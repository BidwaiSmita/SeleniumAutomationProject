package org.tutorialsninjaRegister;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC_register_020 {
    WebDriver driver;

    @BeforeTest
    public void verifyPrivacyCheckboxSelected(){

        WebDriverClass webDriverClass = new WebDriverClass();
        driver = webDriverClass.driveMethod();

        driver.get("https://tutorialsninja.com/demo/");
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();

//       retrieve the value of checkbox
        Boolean isSelect = driver.findElement(By.name("agree")).isSelected();
        System.out.println(isSelect);
//        to re-verify checkbox value
        Assert.assertEquals(Boolean.FALSE,isSelect);
    }

    @Test
    public void proceedWithRegistration(){
        TC_register_001 tc_register_001 = new TC_register_001();
        driver.findElement(By.id("input-firstname")).sendKeys("Smita");
        driver.findElement(By.id("input-lastname")).sendKeys("Bidwai");
        driver.findElement(By.id("input-email")).sendKeys(tc_register_001.GenerateEmail());
        driver.findElement(By.id("input-telephone")).sendKeys("913025235");
        driver.findElement(By.id("input-password")).sendKeys("12345");
        driver.findElement(By.id("input-confirm")).sendKeys("12345");
        driver.findElement(By.name("agree")).click();
        driver.findElement(By.xpath("//input[@value ='Continue']")).click();
        driver.quit();
    }
}
