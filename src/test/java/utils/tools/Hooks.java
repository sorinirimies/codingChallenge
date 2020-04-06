package utils.tools;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.net.MalformedURLException;


public class Hooks {

    private TestContext testContext;

    public Hooks(TestContext context) {
        testContext = context;
    }

    @Before
    public void beforeScenario(Scenario scenario) throws MalformedURLException {
        testContext.getScenarioContext().setContext("Running Scenario", scenario);
        testContext.setDriver();
    }
}
