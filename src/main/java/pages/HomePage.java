package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class HomePage extends BasePage {


    public HomePage(AndroidDriver driver) {
        super(driver);
    }

    private final By firstAddToCartButton = By.xpath("(//android.widget.TextView[@text=\"ADD TO CART\"])[1]");


    public boolean isHomePageDisplayed() {
        return waitForElementToBeDisplayed(firstAddToCartButton, 10);
    }
}

