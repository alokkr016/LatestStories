package io.github.alokkr016.latest_stories.controller;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class LatestStoriesController {

    @GetMapping("/latest-stories")
    public List<Map<String, String>> getLatestStories() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        List<Map<String, String>> newsList = new ArrayList<>();

        try {
            driver.get("https://time.com/");
            try {
                WebElement closePopup = driver.findElement(By.xpath("//*[@id=\"close_icon\"]"));
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
                wait.until(ExpectedConditions.visibilityOf(closePopup)).click();
            } catch (Exception e) {

            }
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement latestStory = driver.findElement(By.className("latest-stories__heading"));
            js.executeScript("arguments[0].scrollIntoView(true);", latestStory);
            List<WebElement> titles = driver.findElements(By.className("latest-stories__item-headline"));
            List<WebElement> links = driver.findElements(By.xpath("//li[@class='latest-stories__item']/a"));
            for (int i = 0; i < titles.size(); i++) {
                String title = titles.get(i).getText();
                String link = links.get(i).getAttribute("href");
                newsList.add(Map.of("title", title, "link", link));
            }

//            System.out.println(newsList);

        } catch (
                Exception e) {
            e.printStackTrace();

        }
        return newsList;
    }

}
