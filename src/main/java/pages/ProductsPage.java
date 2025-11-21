package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductsPage {

    WebDriver driver;

    By addBackpack = By.id("add-to-cart-sauce-labs-backpack");
    By cartIcon = By.id("shopping_cart_container");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addBackpackToCart() {
        driver.findElement(addBackpack).click();
    }

    public void goToCart() {
        driver.findElement(cartIcon).click();
    }

    public boolean isOnProductsPage() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.urlContains("inventory.html"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
