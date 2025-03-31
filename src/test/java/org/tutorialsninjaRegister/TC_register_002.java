package org.tutorialsninjaRegister;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMultipart;
import javax.mail.search.FlagTerm;
import java.time.Duration;
import java.util.Properties;

public class TC_register_002 {

    @Test
    public void EmailVerificationCheck() throws InterruptedException {
        WebDriver driver2 = new ChromeDriver();
        driver2.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver2.manage().window().maximize();
        driver2.get("https://www.amazon.in/");

        driver2.findElement(By.id("nav-link-accountList-nav-line-1")).click();
        Thread.sleep(2000);
        driver2.findElement(By.id("ap_email_login")).sendKeys("smitabidwai2509@gmail.com");
        driver2.findElement(By.xpath("//span[@class='a-button-inner']//input")).click();
        driver2.findElement(By.id("auth-fpp-link-bottom")).click();
        driver2.findElement(By.id("continue")).click();

        System.out.println("Halting the program intentionally for 10 seconds.");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String linksubmit = "cvf-submit-otp-button-announce";

        String AccessCode = "nldp pwpu zrly xwnm";
        int port = 993;
        String host = "imap.gmail.com";
        String username = "smitabidwai2509@gmail.com";
        String appPasscode = AccessCode;
        String link = null;

        String expectedSubject = "amazon.in: Password recovery";
//        String expectedSubject = "Flipkart Account - 854698 is your verification code for secure access";
        String expectedFromEmail = "amazon.in <account-update@amazon.in>";
        String expectedBodyContent = "Someone is attempting to reset the password of your account.";

        try {
            // Mail server connection properties
            Properties properties = new Properties();
            properties.put("mail.store.protocol", "imaps");
            properties.put("mail.imap.host", host);
            properties.put("mail.imap.port", port);
            properties.put("mail.imap.ssl.enable", "true");

            // Connect to the mail server
            Session emailSession = Session.getDefaultInstance(properties);
            Store store = emailSession.getStore("imaps");
            store.connect(host, username, appPasscode); // replace email password with App password

            // Open the inbox folder
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);

            // Search for unread emails
            Message[] messages = inbox.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));

            boolean found = false;
            for(int i = messages.length - 1; i >= 0; i--) {

                Message message = messages[i];

                if (message.getSubject().contains(expectedSubject)) {
                    found = true;
                    Assert.assertEquals(message.getSubject(),expectedSubject);
                    Assert.assertEquals(message.getFrom()[0].toString(), expectedFromEmail);
                    String actualEmailBody = getTextFromMessage(message);
                    System.out.println(actualEmailBody);
                    Assert.assertTrue(actualEmailBody.contains(expectedBodyContent));

                    String[] ar = actualEmailBody.split("600\">");
                    String linkPart = ar[1];
                    String[] arr = linkPart.split("</a>");

                    link = arr[0].trim();

                    break;
                }
            }

            if (!found) {
                System.out.println("No confirmation email found.");
            }

            // Close the store and folder objects
            inbox.close(false);
            store.close();

        }catch(Exception e) {
            e.printStackTrace();
        }

        driver2.navigate().to(link);

        Assert.assertTrue(driver2.findElement(By.name("customerResponseDenyButton")).isDisplayed());

        driver2.quit();

    }

    private static String getTextFromMessage(Message message) throws Exception {
        String result = "";
        if (message.isMimeType("text/plain")) {
            result = message.getContent().toString();
        } else if (message.isMimeType("text/html")) {
            result = message.getContent().toString();
        } else if (message.isMimeType("multipart/*")) {
            MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
            result = getTextFromMimeMultipart(mimeMultipart);
        }
        return result;
    }

    private static String getTextFromMimeMultipart(MimeMultipart mimeMultipart) throws Exception {
        StringBuilder result = new StringBuilder();
        int count = mimeMultipart.getCount();
        for (int i = 0; i < count; i++) {
            BodyPart bodyPart = mimeMultipart.getBodyPart(i);
            if (bodyPart.isMimeType("text/plain")) {
                result.append(bodyPart.getContent());
            } else if (bodyPart.isMimeType("text/html")) {
                result.append(bodyPart.getContent());
            } else if (bodyPart.getContent() instanceof MimeMultipart) {
                result.append(getTextFromMimeMultipart((MimeMultipart) bodyPart.getContent()));
            }
        }
        return result.toString();
    }

}