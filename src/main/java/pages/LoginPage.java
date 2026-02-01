package pages;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
public class LoginPage extends BasePage {



    public LoginPage(AndroidDriver driver) {
        super(driver);
    }

    private final By usernameField = By.xpath("//android.widget.EditText[@content-desc='test-Username']");
    private final By passwordField = By.xpath("//android.widget.EditText[@content-desc=\"test-Password\"]");
    private final By loginButton = By.xpath("//android.widget.TextView[@text=\"LOGIN\"]");


    public void login(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public boolean isLoginPageDisplayed() {
        return waitForElementToBeDisplayed(loginButton, 10);
    }
}
