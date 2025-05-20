package org.tutorialsninjaRegister;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class OrangeHRM_WeDriverClass {

    public WebDriver driver;

    public WebDriver webDriverMethod(){

        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(18));

        driver.findElement(By.xpath("//div[contains(@class,'oxd-input-group')]//div[2]//input[@name='username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@class='oxd-input oxd-input--active'][@name='password']")).sendKeys("admin123");

        driver.findElement(By.xpath("//button[contains(@class,'orangehrm-login-button') and (@type='submit')]")).click();

        return driver;
    }
}
