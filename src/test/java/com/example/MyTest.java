package com.example;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyTest {
    private WebDriver driver;

    @BeforeAll
    public static void setupWebdriverChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "W:/Work/projects/quick-selenium-tests/driver/chrome/win/98/chromedriver.exe");
    }

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
    }

    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void verifyGitHubTitle() {
        driver.get("https://www.github.com");
        MatcherAssert.assertThat(driver.getTitle(), Matchers.containsString("GitHub"));
    }
}
