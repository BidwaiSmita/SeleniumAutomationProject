package org.tutorialsninjaRegister;

import java.util.Date;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

            Date date = new Date();
            String datetoString = date.toString();
            String newStr = datetoString.replaceAll(" ","").replaceAll(":","")+"gmail.com";
            System.out.println(newStr);



    }
}
