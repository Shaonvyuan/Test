package com.shaonvyuan.test.search;
import com.shaonvyuan.test.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchPage extends BasePage {

    public SearchPage(ChromeDriver driver) {
        super(driver);
    }

    public String getFirstTitle() {
        String real = driver.findElement(By.cssSelector(".topic-title")).getText();
        return real;
    }

}
