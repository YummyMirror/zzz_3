import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = {"src/test/resources/cucumber"},
                 glue = {"base", "step_definition"},
                 format = {"json:target/cucumber.json"})
public class Runner extends AbstractTestNGCucumberTests {}
