package org.tutorialsninjaRegister;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class WebDriverClass {

    public WebDriver driver;
   public WebDriver driveMethod(){

//       System.setProperty("webdriver.chrome.driver","C:\\Users\\Smita\\Downloads\\chrome-win64\\chrome-win64\\chromedriver.exe");

       driver = new ChromeDriver();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
       driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/");

        return driver;
    }
   }
