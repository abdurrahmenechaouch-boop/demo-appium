package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",  // chemin vers tes fichiers .feature
        glue = {"stepDefinitions"},               // package contenant Hooks et stepdefs
        plugin = {
                "pretty",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"  // plugin Allure
        },
        monochrome = true
)
public class TestRunner {
}