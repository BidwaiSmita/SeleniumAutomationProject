package org.tutorialsninjaRegister;

import io.github.bonigarcia.wdm.webdriver.WebDriverBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_register_022 {

    WebDriver driver;

    @Test
    public void verifyNavigationToLinkPageWork(){

        WebDriverClass driverClass = new WebDriverClass();
        driver = driverClass.driveMethod();

        driver.get("https://tutorialsninja.com/demo/");
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();

        driver.findElement(By.linkText("Login")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Login']")).isDisplayed());

        driver.findElement(By.xpath("//div[@class='list-group']//a[text()='Register']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Register']")).isDisplayed());
        driver.quit();
    }
}
