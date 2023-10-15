package seminars.five;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SeleniumTest {

    @Test
    public void SearchSeleniumSiteTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Selenium");
        element.submit();
        
        List<WebElement> results = driver.findElements(By.cssSelector("div"));

//        WebElement className = driver.findElement(By.className("tjvcx GvPZzd cHaqb"));

        boolean result = false;

        for (WebElement el : results) {
            if (el.getText().contains("selenium.dev")) result = true;
        }

        assertTrue(result);
        driver.quit();
    }

    @Test
    public void SauceDemoAuthenticationTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");

        WebElement userName = driver.findElement(By.name("user-name"));
        userName.sendKeys("standard_user");
        WebElement userPassword = driver.findElement(By.name("password"));
        userPassword.sendKeys("secret_sauce");
        userPassword.submit();

        WebElement productsLabel = driver.findElement(By.className("title"));

        assertEquals(productsLabel.getText(),"Products");
        driver.quit();
    }

}
