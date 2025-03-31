package org.tutorialsninjaRegister;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.regex.Pattern;

public class TC_register_009 {

    WebDriver driver9 ;

    @Test
    public void enteredEmailVerification() throws InvalidEmailException {

        WebDriverClass webDriverClass = new WebDriverClass();
        driver9 = webDriverClass.driveMethod();

        driver9.findElement(By.xpath("//span[text()='My Account']")).click();
        driver9.findElement(By.linkText("Register")).click();
        driver9.findElement(By.id("input-firstname")).sendKeys("Smita");
        driver9.findElement(By.id("input-lastname")).sendKeys("Bidwai");
        WebElement inputEmail = driver9.findElement(By.id("input-email"));
        inputEmail.sendKeys("jsfhjhghfhgkj@gmail");
        String email = inputEmail.getAttribute("value");
        driver9.findElement(By.id("input-telephone")).sendKeys("913025235");
        driver9.findElement(By.id("input-password")).sendKeys("12345");
        driver9.findElement(By.id("input-confirm")).sendKeys("12345");
        driver9.findElement(By.name("agree")).click();
        driver9.findElement(By.xpath("//input[@value ='Continue']")).click();

//    define a regex pattern

        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(emailRegex);
        if(!(pattern.matcher(email).matches())){
            throw new InvalidEmailException("Invalid email format: "+email);
        }

    }
}
