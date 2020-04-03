package example;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;



    @RunWith(Cucumber.class)
    @CucumberOptions(features = "src/main/java/example/feature"
            , monochrome = false
            , format = { "pretty", "html:target/results/steps" }
            , glue = { "src.main.java.example.stepdefinitions" }
            , strict = true
    )
    public class TestRunner {
    }
