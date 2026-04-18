import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTesting {

    //  DataProvider goes here
    @DataProvider(name = "loginData")
    public Object[][] data() {
        return new Object[][] {
                {"user@gmail.com", "1234"},
                {"wrong@gmail.com", "wrong"}
        };
    }

    //  Test method uses data
    @Test(dataProvider = "loginData")
    public void loginTest(String email, String pass) {

        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:3000/login");

        LoginPage login = new LoginPage(driver);

        login.enterEmail(email);
        login.enterPassword(pass);
        login.clickLogin();

        driver.quit();
    }
}