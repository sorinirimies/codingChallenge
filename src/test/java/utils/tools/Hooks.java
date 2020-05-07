package utils.tools;

import io.appium.mitmproxy.InterceptedMessage;
import io.appium.mitmproxy.MitmproxyJava;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.IOException;
import java.util.List;


public class Hooks {

    private TestContext testContext;
    private MitmproxyJava proxy;
    public List<InterceptedMessage> messages;

    public Hooks(TestContext context) {
        testContext = context;
    }


    @Before
    public void beforeScenario(Scenario scenario) throws IOException {
        testContext.getScenarioContext().setContext("Running Scenario", scenario);
        testContext.setDriver();

//        //proxy part
//        messages = new ArrayList<>();
//        proxy = new MitmproxyJava("/usr/local/homebrew/Cellar/mitmproxy/5.1.1/bin/mitmdump", (InterceptedMessage m) -> {
//            System.out.println("intercepted request for " + m.getRequest().toString());
//            messages.add(m);
//            return m;
//        });
//        proxy.start();
    }

    @After
    public void quit() {
//        proxy.stop();
//        System.out.println(this.messages);
        testContext.getDriver().quit();
    }
}
