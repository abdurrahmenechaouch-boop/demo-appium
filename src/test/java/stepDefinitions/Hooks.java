package stepDefinitions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;


import java.io.ByteArrayInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;

import java.io.ByteArrayInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


public class Hooks {

    public static AndroidDriver driver; // <-- plus de <WebElement>
    public static boolean RUN_ON_BROWSERSTACK;

    @Before
    public void setUp() throws MalformedURLException {
        // 🔹 Vérifie le flag d'environnement
        String runOnBS = System.getenv("RUN_ON_BROWSERSTACK");
        RUN_ON_BROWSERSTACK = "true".equalsIgnoreCase(runOnBS);

        if (RUN_ON_BROWSERSTACK) {
            System.out.println("🚀 Running on BrowserStack");
            setUpBrowserStack();
        } else {
            System.out.println("💻 Running locally");
            setUpLocal();
        }
    }

    public void setUpLocal() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")
                .setPlatformVersion("13.0")
                .setDeviceName("Pixel_7_API_33")
                .setAutomationName("UiAutomator2")
                .setApp("/Users/abdurrahmenechaouch/Downloads/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk")
                .setAppPackage("com.swaglabsmobileapp")         // <- package correct
                .setAppActivity("com.swaglabsmobileapp.MainActivity")
                .setNoReset(false)
                .setNewCommandTimeout(Duration.ofSeconds(300));
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options); // <-- pas de <>
    }


    public void setUpBrowserStack() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setPlatformVersion("13.0");
        options.setDeviceName("Google Pixel 7");
        options.setAutomationName("UiAutomator2");

        options.setApp("bs://c477df20a522ecf458492803855442374b90fa06");
        HashMap<String, Object> bstackOptions = new HashMap<>();
        String username = System.getenv("BROWSERSTACK_USERNAME");
        String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");


        if (username == null || accessKey == null) {
            throw new RuntimeException("❌ BROWSERSTACK_USERNAME ou BROWSERSTACK_ACCESS_KEY non définis !");
        }

        bstackOptions.put("userName", username);
        bstackOptions.put("accessKey", accessKey);
        bstackOptions.put("projectName", "Appium Cucumber Demo");
        bstackOptions.put("buildName", "Login Build 1");
        bstackOptions.put("sessionName", "Successful Login");

        options.setCapability("bstack:options", bstackOptions);
        options.setNoReset(false);
        options.setNewCommandTimeout(Duration.ofSeconds(300));

        driver = new AndroidDriver(
                new URL("https://hub-cloud.browserstack.com/wd/hub"),
                options
        );  }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed() && driver != null) {
            takeScreenshot(scenario.getName());
        }
        if (driver != null) {
            driver.quit();
        }
    }

    // Méthode pour capturer et attacher le screenshot à Allure
    @Attachment(value = "{0}", type = "image/png")
    public byte[] takeScreenshot(String scenarioName) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

}
