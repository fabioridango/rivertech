package ui.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/ui/features",  //the path of the feature files
        glue= {"ui.stepDefinitions", "ui.hooks"}, //the path of the step definition files
        monochrome = true, //display the console output in a proper readable format
        plugin = { "pretty","html:target/cucumber-html-report", "json:target/cucumber-json/CucumberTestReport.json",
                "junit:target/junit-xml/CucumberTestReport.xml"}) //to generate different types of reporting
        //tags = "@UITest")

public class UITestRunner {}
