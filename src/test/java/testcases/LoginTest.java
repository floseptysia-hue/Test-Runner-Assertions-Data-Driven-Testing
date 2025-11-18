package testcases;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest {

    @DataProvider(name = "LoginData")
    public Object[][] getData() {
        return new Object[][] {
                {"admin", "123", true},
                {"wrong", "999", false}
        };
    }

    @Test(dataProvider = "LoginData")
    public void loginTest(String username, String password, boolean expected) {
        boolean result = username.equals("admin") && password.equals("123");
        Assert.assertEquals(result, expected);
    }
}
