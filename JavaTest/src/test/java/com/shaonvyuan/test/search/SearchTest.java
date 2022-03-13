package com.shaonvyuan.test.search;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.containsString;

public class SearchTest {
    @Test
    void search() {
        //不建议使用这种方式，推荐使用环境变量
        System.setProperty(
                "webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe"
        );
        ChromeDriver driver = new ChromeDriver();
        //selenium3与4版本之间参数不一样
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://ceshiren.com/");
        driver.findElement(By.id("search-button")).click();
        driver.findElement(By.id("search-term")).sendKeys("selenium" + Keys.ENTER);
        String real = driver.findElement(By.cssSelector(".topic-title")).getText();
        assertThat(real, containsString("selenium"));
    }
}
