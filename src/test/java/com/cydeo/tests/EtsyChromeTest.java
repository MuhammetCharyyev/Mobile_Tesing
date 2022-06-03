package com.cydeo.tests;

import com.cydeo.utils.ConfigurationReader;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EtsyChromeTest extends WebTestBase {

    @Test
    public void etsySearchTest() throws InterruptedException {
        driver.get("https://www.etsy.com");//get the link
        //Thread.sleep(3000);
        //we entered to the regular web page and then 'inspect' and choose 'Toggle device toolbar'
        //then we choose 'Dimensions: Pixel 3'
        //to locate search box we used usual inspection and locate 'By.name("search_query"'
        WebElement searchField = driver.findElement(By.name("search_query"));
        searchField.sendKeys("wooden spoon" + Keys.ENTER);
        //print number of results
        //as 'results' element is dynamic we used 'contain' method to catch and print all results after search
        WebElement results = driver.findElement(By.xpath("//span[contains(text(),'results,')]"));
        System.out.println("results.getText() = " + results.getText());
        //results.getText() = 29,454 results,
    }

    @Test
    public void loginTest() throws InterruptedException {
        //use login
        String email = ConfigurationReader.getProperty("email");
        String password = ConfigurationReader.getProperty("password");

        driver.get("https://www.etsy.com");

        WebElement signIn = driver.findElement
                        (By.xpath("//span[contains(text(),'Sign in')]/.."));
        signIn.click();

        WebElement userNameField = driver.findElement(By.name("email"));
        userNameField.sendKeys(email + Keys.ENTER);

        Thread.sleep(3000);

        WebElement passwordField = driver.findElement(By.name("password"));

        passwordField.sendKeys(password + Keys.ENTER);

    }



}