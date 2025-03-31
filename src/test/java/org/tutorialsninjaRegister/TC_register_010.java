package org.tutorialsninjaRegister;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.regex.Pattern;

public class TC_register_010 {

    WebDriver driver;

    @Test
    public void validatePhoneNumber() throws InvalidPhoneNumberException {

        WebDriverClass webDriverClass = new WebDriverClass();
        driver = webDriverClass.driveMethod();
        TC_register_001 tc_register_001 = new TC_register_001();

        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.id("input-firstname")).sendKeys("Smita");
        driver.findElement(By.id("input-lastname")).sendKeys("Bidwai");
        driver.findElement(By.id("input-email")).sendKeys(tc_register_001.GenerateEmail());

        WebElement phoneNo = driver.findElement(By.id("input-telephone"));
        phoneNo.sendKeys("1234567899");
        String phone = phoneNo.getAttribute("value");

        driver.findElement(By.id("input-password")).sendKeys("12345");
        driver.findElement(By.id("input-confirm")).sendKeys("12345");
        driver.findElement(By.name("agree")).click();
        driver.findElement(By.xpath("//input[@value ='Continue']")).click();

        String phoneRegex = "^[0-9]{10}$";
        Pattern pattern = Pattern.compile(phoneRegex);

        if (!(pattern.matcher(phone).matches())){
            throw new InvalidPhoneNumberException("Invalid Phone Number :" +phone);
        }
    driver.quit();
    }

}
