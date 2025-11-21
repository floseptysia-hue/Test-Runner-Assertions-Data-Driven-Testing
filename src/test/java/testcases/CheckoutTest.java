package testcases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.ProductsPage;
import pages.CartPage;
import pages.CheckoutPage;
import utils.DriverFactory;
import utils.ExcelUtils;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class CheckoutTest {

    WebDriver driver;

    @DataProvider(name = "checkoutData")
    public Object[][] getCheckoutData() {
        ExcelUtils excel = new ExcelUtils("src/test/resources/testdata/CheckoutData.xlsx", "Sheet1");
        return excel.getTestData();
    }

    @BeforeMethod
    public void setup() {
        DriverFactory.quitDriver();   // <— tambahkan ini untuk memastikan fresh
        driver = DriverFactory.getDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @Test(dataProvider = "checkoutData")
    public void testCheckout(String firstName, String lastName, String postalCode) {
        LoginPage login = new LoginPage(driver);
        ProductsPage products = new ProductsPage(driver);
        CartPage cart = new CartPage(driver);
        CheckoutPage checkout = new CheckoutPage(driver);

        login.setUsername("standard_user");
        login.setPassword("secret_sauce");
        login.clickLogin();

        Assert.assertTrue(
                driver.getCurrentUrl().contains("inventory.html"),
                "Login FAILED - Products page not displayed"
        );

        /* ADD ITEM TO CART */
        products.addBackpackToCart();
        products.goToCart();

        Assert.assertTrue(driver.getCurrentUrl().contains("cart.html"));

        /* CHECKOUT PROSES */
        cart.clickCheckout();
        System.out.println("URL before checkout = " + driver.getCurrentUrl());
        System.out.println("CURRENT URL = " + driver.getCurrentUrl());
        System.out.println("PAGE TITLE = " + driver.getTitle());

        Assert.assertTrue(
                driver.getCurrentUrl().contains("checkout-step-one.html"),
                "Checkout Step 1 NOT displayed"
        );

        checkout.fillCustomerData(firstName.trim(), lastName.trim(), postalCode.trim());
        checkout.clickContinue();

        // wait for next page
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.urlContains("checkout-step-two.html"));

        Assert.assertTrue(
                driver.getCurrentUrl().contains("checkout-step-two.html"),
                "Checkout Step 2 NOT displayed"
        );
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
