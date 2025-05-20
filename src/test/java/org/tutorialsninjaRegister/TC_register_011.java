package org.tutorialsninjaRegister;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_register_011 {

    WebDriver driver11;

    @Test
    public void verifyingPlaceholder(){

        WebDriverClass webDriverClass = new WebDriverClass();
        driver11 = webDriverClass.driveMethod();

        driver11.findElement(By.xpath("//span[text()='My Account']")).click();
        driver11.findElement(By.linkText("Register")).click();

        String expectedPlaceholderFirstName = "First Name";
        Assert.assertEquals(driver11.findElement(By.id("input-firstname")).getAttribute("placeholder"),expectedPlaceholderFirstName);

//        we can check for all other placeholders
        driver11.quit();
    }
}
