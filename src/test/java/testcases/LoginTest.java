package testcases;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;
//import pages.ProductsPage;
import utils.DriverFactory;
import utils.ExcelUtils;
import org.openqa.selenium.WebDriver;

public class LoginTest {

    WebDriver driver;

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        ExcelUtils excel = new ExcelUtils("src/test/resources/testdata/LoginData.xlsx", "Sheet");
        return excel.getTestData();
    }

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.getDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password) {
        LoginPage login = new LoginPage(driver);
//        ProductsPage products = new ProductsPage(driver);
        System.out.println("username : "+ username.trim());
        System.out.println("password : "+ password.trim());

        login.setUsername(username);
        login.setPassword(password);
        login.clickLogin();

        if (username.equals("locked_out_user")) {
            Assert.assertTrue(login.getErrorMessage().contains("locked"), "Locked out validation FAILED");
        }
//        else {
//            Assert.assertTrue(products.isOnProductsPage(), "Login Failed");
//        }
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
