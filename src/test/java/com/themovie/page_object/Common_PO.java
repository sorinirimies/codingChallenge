package com.themovie.page_object;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.AppProperties;
import utils.tools.TestContext;

import java.time.Duration;

public class Common_PO {
    private AppiumDriver<?> driver;

    public Common_PO(TestContext context) {
        this.driver = context.getDriver();
    }

    public void installApplication(){
        driver.installApp(AppProperties.getApk());
    }

    public void check_appIsOpen() {
        Assert.assertTrue(driver.isAppInstalled(AppProperties.getAppName()));
        check("xpath","//*[@text='TheMovies']");
    }

    public void click_button_movie(){
        click("id","action_one");
    }
    public void click_button_star(){
        click("id","action_three");
    }
    public void click_button_tvshow(){
        click("id","action_two");
    }
    public void click_star(String name){
        scrollDowntoXPath("//*[@text='"+name+"']");
        click("xpath","//*[@text='"+name+"']");
    }
    public void click_movie(String name){
        scrollDowntoXPath("//*[@text='"+name+"']");
        click("xpath","//*[@text='"+name+"']");
    }
    public void click_tvshow(String name){
        scrollDowntoXPath("//*[@text='"+name+"']");
        click("xpath","//*[@text='"+name+"']");
    }
    public void check_star(String name){
        Assert.assertTrue(check("id","person_detail_name"));
        Assert.assertTrue(check("xpath","//*[@text='"+name+"']"));
    }
    public void check_movie(String name){
        Assert.assertTrue(check("xpath","//*[@text='"+name+"']"));
        Assert.assertTrue(check("id","detail_header_star"));
    }
    public void check_tvshow(String name){
        Assert.assertTrue(check("xpath","//*[@text='"+name+"']"));
        Assert.assertTrue(check("id","detail_header_star"));
    }
    public void check_page_movie(){
        Assert.assertTrue(check("id","item_poster_post"));
        Assert.assertTrue(check("id","item_poster_title"));
    }
    public void check_page_star(){
        Assert.assertTrue(check("id","item_person_name"));
    }
    public void check_page_tvshow(){
        //same as check_page_movie > no differences on first sight
        Assert.assertTrue(check("id","item_poster_post"));
        Assert.assertTrue(check("id","item_poster_title"));
    }

    public void click_button_back(){
        click("xpath","//*[@class='android.widget.ImageButton']");
    }
    public void click_toolbar_home(){
        click("id","toolbar_home");
    }

    private Boolean check(String mode, String xpath){
        boolean isElementPresent;
        try {
            MobileElement mobileElement;
            if ("id".equals(mode)) {
                mobileElement = (MobileElement) driver.findElement(By.id(xpath));
            } else {
                mobileElement = (MobileElement) driver.findElement(By.xpath(xpath));
            }

                WebDriverWait wait = new WebDriverWait(driver, 3000);
                wait.until(ExpectedConditions.visibilityOf(mobileElement));
                isElementPresent = mobileElement.isDisplayed();
                return isElementPresent;
        }catch(Exception e){
            isElementPresent = false;
            System.out.println(e.getMessage());
            return isElementPresent;
        }

    }


    private void click(String mode, String xpath){
        if ("id".equals(mode)){
            driver.findElementById(xpath).click();
        }
            else driver.findElementByXPath(xpath).click();
    }


    public void scrollDowntoXPath(String xPath) {
        boolean isElementPresent=false;
        int count=1;
        org.openqa.selenium.Dimension size = driver.manage().window().getSize();
        int startVerticalY = (int) (size.height * 0.7);
        int endVerticalY = (int) (size.height * 0.3);
        int startVerticalX = size.width / 2;
        try {
            driver.findElement(By.xpath(xPath));
        } catch (Exception e){
            while (!isElementPresent) {
                try {
                    driver.findElement(By.xpath(xPath));
                    isElementPresent = false;
                    break;
                } catch (Exception NoSuchElementException) {
                    count = count + 1;
                    new TouchAction<>(driver).press(PointOption.point(startVerticalX, startVerticalY))
                            .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(startVerticalX, endVerticalY)).release()
                            .perform();
                    if (count == 50) {
                        break;
                    }
                }
            }
        }
    }


}
