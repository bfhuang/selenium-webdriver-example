package com;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class prompTest {
    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
//        driver download place: http://www.seleniumhq.org/download/
        System.setProperty("webdriver.chrome.driver",
                "/Users/bfhuang/Documents/projects/selenium-webdriver-example/lib/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void test() throws Exception {
        driver.get("https://mail.rediff.com/cgi-bin/login.cgi");



        //        xpath  begin with // and then tag name, and then [], in the [], use @attribute=value
        driver.findElement(By.name("proceed")).click();


        Alert alert = driver.switchTo().alert();

        Thread.sleep(1000);

        assertThat(alert.getText(), is("Please enter a valid user name"));

        alert.accept();
        driver.switchTo().defaultContent();

        WebElement demo = driver.findElement(By.id("demo"));

        assertThat(driver.findElement(By.name("proceed")), is("Go"));

    }


    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
