package org.tutorialsninjaRegister;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_orangeHRM_001 {

    WebDriver driver = new ChromeDriver();

    @Test
    public void verifyRegistrastionPage(){

        TC_register_001 register_001 = new TC_register_001();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(18));

        driver.findElement(By.xpath("//div[contains(@class,'oxd-input-group')]//div[2]//input[@name='username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@class='oxd-input oxd-input--active'][@name='password']")).sendKeys("admin123");

        driver.findElement(By.xpath("//button[contains(@class,'orangehrm-login-button') and (@type='submit')]")).click();

        //point to remember
        Assert.assertEquals(driver.findElements(By.xpath("//input[@name='username']/ancestor::div[contains(@class,'oxd-input-group')]//span[text()='Required']")).size(),0);
        Assert.assertEquals(driver.findElements(By.xpath("//input[@name='password']/following::span")).size(),0);

//        re-verifying that after successfull login if we can see the Dashboard page or not
        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='oxd-topbar-header-breadcrumb']//h6")).isDisplayed());
        driver.quit();
    }
}


//*[@id="app"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/span