package testcases;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.ProductsPage;
import pages.CartPage;
import utils.DriverFactory;
import utils.ExcelUtils;
import org.openqa.selenium.WebDriver;

public class AddToCartTest {

    WebDriver driver;

    @DataProvider(name = "addToCartData")
    public Object[][] getAddToCartData() {
        ExcelUtils excel = new ExcelUtils("src/test/resources/testdata/AddToCartData.xlsx", "Sheet1");
        return excel.getTestData();
    }

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.getDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @Test(dataProvider = "addToCartData")
    public void testAddToCart(String username, String password, String itemName) {
        LoginPage login = new LoginPage(driver);
        ProductsPage products = new ProductsPage(driver);

//        CartPage cart = new CartPage(driver);
//        login.setUsername("standard_user");
//        login.setPassword("secret_sauce");

        login.setUsername(username.trim());
        login.setPassword(password.trim());
        login.clickLogin();
        System.out.println("Current URL after login: " + driver.getCurrentUrl());

        // VALIDASI LOCKED
        if (username.equals("locked_out_user")) {
            Assert.assertTrue(login.getErrorMessage().contains("locked"));
            return; // jangan lanjut addToCart
        }

        // VALIDASI LOGIN SUKSES UNTUK USER NORMAL
        Assert.assertTrue(
                driver.getCurrentUrl().contains("inventory.html"),
                "Login FAILED - cannot find Products Page"
        );


        // support itemName dynamically:
        if (itemName.equalsIgnoreCase("backpack")) {
            products.addBackpackToCart();
        }

        products.goToCart();
        Assert.assertTrue(driver.getCurrentUrl().contains("cart.html"));
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
