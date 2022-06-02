package api.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/api/feature",  // the path of the feature files
        glue= {"api.stepDefinitions"}, // the path of the API step definition files
        monochrome = true, // display the console output in a proper readable format
        plugin = { "pretty","html:target/cucumber-html-report", "json:target/cucumber-json/CucumberTestReport.json",
                "junit:target/junit-xml/CucumberTestReport.xml"}) //generate different types of reporting
        //tags = "@APITest")

public class APITestRunner {}