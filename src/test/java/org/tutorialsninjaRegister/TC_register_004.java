package org.tutorialsninjaRegister;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
//verifyProperNotificationDisplayed
public class TC_register_004 {

    @Test
    public void verifyProperNotificationDisplayed(){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/");

        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();

        driver.findElement(By.xpath("//input[@value ='Continue']")).click();

        String firstWarning = "First Name must be between 1 and 32 characters!";
        String lastWarning ="Last Name must be between 1 and 32 characters!";
        String emailWarning = "E-Mail Address does not appear to be valid!";
        String teleponeWarning = "Telephone must be between 3 and 32 characters!";
        String passwordWarning = "Password must be between 4 and 20 characters!";
        String privacyWarning = "Warning: You must agree to the Privacy Policy!";

        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText()
                ,firstWarning);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText(),
                lastWarning);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText(),
                emailWarning);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText(),
                teleponeWarning);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText(),
                passwordWarning);
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='account-register']//div[@class='alert alert-danger alert-dismissible']")).getText(),
                privacyWarning);
        driver.quit();

    }
}
