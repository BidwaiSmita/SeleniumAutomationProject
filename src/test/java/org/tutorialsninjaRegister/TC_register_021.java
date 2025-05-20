package org.tutorialsninjaRegister;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_register_021 {

    WebDriver driver;

    @Test
    public void verifyPasswordFieldIsToggle(){

        WebDriverClass driverClass = new WebDriverClass();
        driver = driverClass.driveMethod();
        driver.get("https://tutorialsninja.com/demo/");

        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();

//        Verify whether password field should be toggle means when we type any value in password field it should not be visible
//        for password type=password so that's why here we are verifying using the attribute type

        Assert.assertEquals(driver.findElement(By.id("input-password")).getAttribute("type"),"password");
        Assert.assertEquals(driver.findElement(By.id("input-confirm")).getAttribute("type"),"password");
        driver.quit();
    }
}
