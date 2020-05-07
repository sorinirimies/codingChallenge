package utils;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

/*
TAGS : "tag1 or (tag2 and tag3)" : available tags are @Sample / @Movie / @Star / @TvShow / @Full
 */
@CucumberOptions(
        plugin = {"pretty", "html:reports/cucumber-html"},
        glue= {"utils.tools","com.themovie.steps"},
        features = {"src/test/resources/gradle.cucumber"},
        tags = {""},
        strict = true
        //dryRun = true
)
public class TestBase {

    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpTestNGCucumber(){
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(description = "Runs Cucumber Feature", dataProvider = "scenarios")
    public void feature(PickleWrapper pickleEvent, FeatureWrapper cucumberFeature) throws Throwable{
        testNGCucumberRunner.runScenario(pickleEvent.getPickle());
    }

    @DataProvider
    public Object[][] scenarios() {
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        testNGCucumberRunner.finish();
    }
}
