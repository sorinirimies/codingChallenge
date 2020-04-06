package utils.tools;

import io.appium.java_client.AppiumDriver;
import utils.AppMainFunction;
import utils.AppProperties;

import java.net.MalformedURLException;

public class TestContext {

    private ScenarioContext scenarioContext;
        public AppiumDriver<?> driver;

    public TestContext(){
        scenarioContext = new ScenarioContext();
    }

    public AppiumDriver<?> getDriver() {
        return this.driver;
    }

    public void setDriver() throws MalformedURLException {
        this.driver = (new AppMainFunction()).getDriver();
    }

    public ScenarioContext getScenarioContext() {
        return scenarioContext;
    }

    public void uninstallApplication(){
        this.driver.removeApp(AppProperties.getAppName());
    }
}
