package themoviestest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

public class StepDefinitions {
	  public static URL url;
	  public static DesiredCapabilities capabilities;
	  public static AndroidDriver<MobileElement> driver;
	
	
	
	@Given("today is Sunday")
	public void today_is_Sunday() throws MalformedURLException {
	    final String URL_STRING = "http://127.0.0.1:4723/wd/hub";
	    url = new URL(URL_STRING);
	//3
	    capabilities = new DesiredCapabilities();
	    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
	    capabilities.setCapability(MobileCapabilityType.APP, "C:\\tom\\2020\\03\\porsche\\challange\\TheMovies-master\\app\\build\\outputs\\apk\\debug\\app-debug.apk");
	    capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
	    capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
	    //4
	    driver = new AndroidDriver<MobileElement>(url, capabilities);
	    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	   driver.resetApp();

	}
	
	
	
	
	@Given("the app is up and running")
	public void the_app_is_up_and_running() throws MalformedURLException {
	    final String URL_STRING = "http://127.0.0.1:4723/wd/hub";
	    url = new URL(URL_STRING);
	//3
	    capabilities = new DesiredCapabilities();
	    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
	    capabilities.setCapability(MobileCapabilityType.APP, "C:\\tom\\2020\\03\\porsche\\challange\\TheMovies-master\\app\\build\\outputs\\apk\\debug\\app-debug.apk");
	    capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
	    capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
	    //4
	    driver = new AndroidDriver<MobileElement>(url, capabilities);
	    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	   driver.resetApp();

	}

	@When("i click at cars movie")
	public void i_click_at_cars_movie() {
		List<MobileElement> elements = driver.findElementsByXPath("//android.widget.TextView[@text = 'Cars']");

		elements.get(0).click();

		//		MobileElement el1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.RelativeLayout/android.widget.TextView");
//		el1.click();
//		MobileElement el2 = (MobileElement) driver.findElementById("com.skydoves.themovies:id/detail_header_release");
//		el2.click();
	}

	@Then("i see the correct release date")
	public void i_see_the_correct_release_date() {
		
		
		List<MobileElement> elements = driver.findElementsByXPath("//android.widget.TextView[@resource-id = 'com.skydoves.themovies:id/detail_header_release']");
	
		assertEquals("Release Date : 2006-06-08", elements.get(0).getAttribute("text").toString());
//		MobileElement el2 = (MobileElement) driver.findElementById("com.skydoves.themovies:id/detail_header_release");
//		
//		assertEquals("", el2.getText());
	}

	
	
	
	
}
