package com.digital.poc;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Salesforce {
    public static AndroidDriver driver;
    @Test
    public static void SalesforceNavigate() throws IOException, InterruptedException {
        setCapLocal();
        waitImplicit(10);


    }
    public static void waitImplicit(int timetowait) {
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(timetowait, TimeUnit.SECONDS);
    }

    public static void setCapLocal() throws InterruptedException, MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platform", "android");
        //Emulator testing
        //cap.setCapability("deviceName", "emulator-5554");
        //Device testing
        cap.setCapability("deviceName", "e9b54af9");
        cap.setCapability("newCommandTimeout", "200");
        cap.setCapability("app","Salesforce");
        //cap.setCapability("app-activity","Salesforce1");
        //cap.setCapability("bundleId", "Salesforce1");

//cap.setCapability("appPackage", "com.salesforce.chatter");
//cap.setCapability("appActivity", "activity.S1MainFragmentActivity");


        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        //driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        //driver = new AndroidDriver( new URL("http://SAUCE_USERNAME:SAUCE_ACCESS_KEY@ondemand.saucelabs.com:80/wd/hub"), capabilities);
        //driver = new AndroidDriver( new URL("http://vamsipappala:5C674486A1E6401EA30567A950AD1BFB@ondemand.saucelabs.com:80/wd/hub"), capabilities);
        // vamsipappala
//5C674486A1E6401EA30567A950AD1BFB
    }
}