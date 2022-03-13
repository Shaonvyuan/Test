package com.shaonvyuan.test.search;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class MainPage {

    private final By search_button = By.id("search-button");
    private final By search_title=By.xpath("/html/body/header/div/hgroup/span/a");
    private ChromeDriver driver;
    private final By term = By.id("search-term");
    ;

    public MainPage start() throws InterruptedException {
        System.setProperty(
                "webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe"
        );
        driver = new ChromeDriver();
        //selenium3与4版本之间参数不一样
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("http://www.shaonvyuan.com/");
        sleep(10);

        return this;
    }

    public SearchPage search(String keyword) {
        driver.findElement(search_button).click();
        driver.findElement(term).sendKeys(keyword + Keys.ENTER);

        return new SearchPage(driver);
    }
    public String searchTitle() {
        WebElement element = driver.findElement(search_title);
        String title=element.getText();
        return title;
    }
}
