package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

    @RunWith(Cucumber.class)
    @CucumberOptions(
            features = "src/test/java/features",
            glue = "stepDefinition",
            tags = "@FEScenarios",  // Specify the tag to run (FE Tag: @FEScenarios, API Tag: @APIScenarios)
            plugin = {"pretty", "html:target/cucumber-reports"}, // Reporting options
            monochrome = true                         // Clean console output
    )
    public class TestRunner {
    }

