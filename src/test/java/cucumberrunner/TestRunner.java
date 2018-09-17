package cucumberrunner;

import cucumber.api.CucumberOptions;
import testcases.TestCasesBase;


@CucumberOptions(features = "src/test/java/cucumberfeatures", glue = {"cucumbersteps"}
,plugin = {"pretty","html: target/cucumber-html-report"})
public class TestRunner extends TestCasesBase {

}
