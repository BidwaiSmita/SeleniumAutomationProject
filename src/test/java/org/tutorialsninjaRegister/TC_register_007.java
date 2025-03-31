package org.tutorialsninjaRegister;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_register_007 {

    WebDriver driver7;

    @Test
    public void verifyNavigatingToRegisterAccountPage(){

        WebDriverClass driverClass = new WebDriverClass();
        driver7 = driverClass.driveMethod();

        driver7.findElement(By.xpath("//span[@class='hidden-xs hidden-sm hidden-md'][text()='My Account']")).click();
        driver7.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[text()='Register']")).click();
        Assert.assertTrue(driver7.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Register']")).isDisplayed());

        driver7.findElement(By.xpath("//span[@class='hidden-xs hidden-sm hidden-md'][text()='My Account']")).click();
        driver7.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[text()='Login']")).click();
        driver7.findElement(By.xpath("//div[@class='col-sm-6']//a[text()='Continue']")).click();
        Assert.assertTrue(driver7.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Register']")).isDisplayed());
//        Assert.assertFalse(driver7.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Register']")).isDisplayed());
        driver7.findElement(By.xpath("//span[@class='hidden-xs hidden-sm hidden-md'][text()='My Account']")).click();
        driver7.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[text()='Login']")).click();
        driver7.findElement(By.xpath("//a[@class='list-group-item'][text()='Register']")).click();
        Assert.assertTrue(driver7.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Register']")).isDisplayed());

        driver7.quit();


    }
}
