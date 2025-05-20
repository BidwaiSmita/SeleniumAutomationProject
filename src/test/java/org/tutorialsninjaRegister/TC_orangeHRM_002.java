package org.tutorialsninjaRegister;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_orangeHRM_002 {

    WebDriver driver;

    @Test
    public void verifyEnteredUserRecordFind(){

        OrangeHRM_WeDriverClass orangeHRM_weDriverClass = new OrangeHRM_WeDriverClass();
        driver = orangeHRM_weDriverClass.webDriverMethod();

        driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][text()='Admin']")).click();
        driver.findElement(By.xpath("//div[contains(@class,'oxd-grid-item--gutters')]//input[contains(@class,'oxd-input--active')]")).sendKeys("Admin");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span'][text()='(1) Record Found']")).isDisplayed());
        driver.quit();
    }
}
