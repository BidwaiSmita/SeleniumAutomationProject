package org.tutorialsninjaRegister;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.time.Duration;

public class TC_register_018 {


	WebDriver driver;

	@Test
	public void verifyHeightandWidth(){

		WebDriverClass webDriverClass = new WebDriverClass();
		driver = webDriverClass.driveMethod();

		String expectedWidth = "33.9882px";
		String expectedHeight = "701.253px";
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String actualHeight = driver.findElement(By.id("input-firstname")).getCssValue("height");
		String actualWidth = driver.findElement(By.id("input-lastname")).getCssValue("width");

		Assert.assertEquals(actualHeight,expectedHeight);
		System.out.println(actualWidth);
		System.out.println(actualHeight);
		driver.quit();

	}
}
