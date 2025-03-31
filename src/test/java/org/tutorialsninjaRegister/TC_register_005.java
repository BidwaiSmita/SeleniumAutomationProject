package org.tutorialsninjaRegister;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.time.Duration;
import java.util.Date;

public class TC_register_005 {

    WebDriver driver ;

    @Test
    public void VerifingRegistartionFields(){

        WebDriverClass driverClass1 = new WebDriverClass();
        driver = driverClass1.driveMethod();
        driver.get("https://tutorialsninja.com/demo/");

        //enter the value in text box for registration & complete the registration
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.id("input-firstname")).sendKeys("Smita");
        driver.findElement(By.id("input-lastname")).sendKeys("Bidwai");
        driver.findElement(By.id("input-email")).sendKeys(GenerateEmail());
        driver.findElement(By.id("input-telephone")).sendKeys("913025235");
        driver.findElement(By.id("input-password")).sendKeys("12345");
        driver.findElement(By.id("input-confirm")).sendKeys("12345");
        driver.findElement(By.name("agree")).click();
        driver.findElement(By.xpath("//input[@value ='Continue']")).click();

        //for re-verification
        // to check if ur account gets created or not
        //1st way
        //but we can verify by many ways , as after login you can see different text/tags/anything that shows that
        //your acc get created by comparing that thing you can verify that your account gets created
        Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());

        //next step
        //click on continue button and go to your account details page
        driver.findElement(By.linkText("Continue")).click();

        //verify that you are now in your profile page or not
        Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
//        driver.quit();
    }
    //generate new email each time based on Date
    public String GenerateEmail(){
        Date date = new Date();
        String datetoString = date.toString();
        String newStr = datetoString.replaceAll(" ","").replaceAll(":","")+"@gmail.com";
        return newStr;
    }

    @Test
    public void subsribeRadioButtonCheck() {
        //check if subscribe radio yes is clicked or not
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//div[@id='account-account']//div//ul[4]//li//a")).click();
        boolean selection = driver.findElement(By.xpath("//div[@class='col-sm-10']//label[1]//input")).isSelected();
        System.out.println("radio button is selected :, " + selection);
    }
}
