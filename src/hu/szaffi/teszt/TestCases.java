package hu.szaffi.teszt;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TestCases {

    private WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    @Test
    public void guruWebPageTitleCheck() {
        WebDriver driver = getDriver();
        String baseUrl = "http://demo.guru99.com/test/newtours/";
        String expectedTitle = "Welcome: Mercury Tours";

        driver.get(baseUrl);
        String actualTitle = driver.getTitle();
        if (actualTitle.contentEquals(expectedTitle)) {
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }
        driver.close();
    }

    @Test
    public void guruGetElement() {
        WebDriver driver = getDriver();
        String baseUrl = "http://www.facebook.com";

        driver.get(baseUrl);
        String tagName = driver.findElement(By.id("email")).getTagName();
        System.out.println(tagName);
        driver.close();
        System.exit(0);
    }

    @Test
    public void testGoogleSearch() throws InterruptedException {
        // Optional, if not specified, WebDriver will search your path for chromedriver.
        WebDriver driver = getDriver();
        driver.get("http://www.google.com");
        Thread.sleep(3000);  // Let the user actually see something!
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("ecetes ubi");
        searchBox.submit();
        Thread.sleep(3000);  // Let the user actually see something!
        driver.quit();
    }
}
