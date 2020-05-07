package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppMainFunction {
    private AppiumDriver<?> driver;

    public AppMainFunction() throws MalformedURLException {
        AppProperties.initAppProperties();
        this.driver = setupAppium();
    }

    public AppiumDriver<?> setupAppium() throws MalformedURLException {
        final String URL_STRING = "http://127.0.0.1:4723/wd/hub";
        URL url = new URL(URL_STRING);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "appium");
        capabilities.setCapability("allowTestPackages", "true");
        capabilities.setCapability(MobileCapabilityType.APP, AppProperties.getApk());
        driver = new AndroidDriver<MobileElement>(url, capabilities);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        return driver;
    }

    public AppiumDriver<?> getDriver(){
        return this.driver;
    }



}