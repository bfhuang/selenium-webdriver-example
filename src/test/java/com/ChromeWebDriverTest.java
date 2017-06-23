package com;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ChromeWebDriverTest {
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
        driver.get("https://www.baidu.com/");
        driver.findElement(By.id("kw")).sendKeys("some key words");
        driver.findElement(By.id("su")).click();

        Thread.sleep(1000);

        String nums = driver.findElement(By.className("nums")).getText();
        assertThat(nums.contains("百度为您找到相关结果约"), is(true));
    }


    @Test
    public void testName1() throws Exception {
        driver.get("https://www.baidu.com/");
        driver.findElement(By.id("kw")).sendKeys("some key words");
        driver.findElement(By.id("su")).click();

        Thread.sleep(1000);

        String nums = driver.findElement(By.className("nums")).getText();
        assertThat(nums.contains("百度为您找到相关结果约"), is(true));
    }


    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
