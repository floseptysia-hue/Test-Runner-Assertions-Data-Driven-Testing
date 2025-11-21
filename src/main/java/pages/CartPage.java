package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    WebDriver driver;

    By checkoutBtn = By.id("checkout");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCheckout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement btn = wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutBtn));

        // Scroll ke element
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn);

        // JS click (bypass semua masalah Selenium click)
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
    }
}