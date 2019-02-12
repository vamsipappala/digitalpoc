package com.digital.poc;



import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.Dimension;

//import  java.time.LocalDate;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
//import static java.time.Duration.ofMillis;
//import static java.time.Duration.ofSeconds;

import static io.appium.java_client.touch.offset.PointOption.point;
//import static java.time.Duration.ofSeconds;

public class Wsj {
    public static AndroidDriver driver;
    @Test
    public static void wsjnavigate() throws IOException, InterruptedException {
        //
        //Set capabilities
        setCapLocal(); //Enable this to run test locally
       // setCapCloud(); // Enable this to run test on Cloud/SauceLabs
        waitImplicit(10);

        //Click Skip
        findElementClick("id","learnmoreNegativeButton");
        waitForPage();

        //Change the Theme To Dark- Shows can edit the Ribbon
        findElementClick("xpath",".//*[@text='Dark Theme']");
        waitForPageLong();
        
        //Look for Search and enter the text to search
        findElementClick("accessibility id","Search");
        waitForPageLong();
        driver.findElement("id","search_src_text").sendKeys("US Stocks"+"\n");

        //Click on the searched news
        findElementClick("xpath",".//*[@instance=1]");
        waitForPage();
        findElementClick("accessibility id","Navigate up");
        waitForPageLong();
        findElementClick("accessibility id","Collapse");
        findElementClick("xpath",".//*[@content-desc='Collapse']");

      // Navigate thru different Tabs
        waitForPage();
        findElementClick("xpath",".//*[@text='Business & Tech']");
        waitForPage();

//        MobileElement element = (MobileElement) driver.findElement("xpath",".//*[@text='Business & Tech']");
//        swipeDown(element);

        findElementClick("accessibility id","Markets");
        waitForPage();
        findElementClick("accessibility id","U.S.");
        waitForPage();
        findElementClick("accessibility id","World");

        // Exit Driver
       tearDown();










        //new TouchActions(driver).press(115, 650).waitAction(ofSeconds(1)).moveTo(115, 350).release().perform();





        //driver.findElementByAccessibilityId("Navigate up").click();

      /* WebDriverWait wait = new WebDriverWait(driver, 100);
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(By.id("cancelRegister")));
        el.click();
        */

    }


   public static void findElementClick(String identifyby, String val){
        driver.findElement(identifyby, val).click();
    }

    public static void waitForPage() throws InterruptedException {
        Thread.sleep(5000);
    }
    public static void waitForPageLong() throws InterruptedException {
        Thread.sleep(8000);
    }
    public static void waitImplicit(int timetowait) {
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
        cap.setCapability("app", "C:\\VAMSI\\Automation\\Mobile\\wsj.apk");
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

    public static void setCapCloud() throws InterruptedException, MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "4.4");
        cap.setCapability("deviceName", "Samsung Galaxy Nexus GoogleAPI Emulator");
        //cap.setCapability("deviceID", "Samsung_Galaxy_S6_sjc_free");
        cap.setCapability("newCommandTimeout", "9000");
        //cap.setCapability("testobject_app_id", "7");
        //cap.setCapability("app", "sauce-storage:wallStreetJournal");
        cap.setCapability("app", "sauce-storage:WSJ3");
        cap.setCapability("tags", "Tag1");

        //cap.setCapability("app", "sauce-storage:Sample-App.apk");
        //cap.setCapability("app", "C:\\VAMSI\\Automation\\Mobile\\wsj.apk");
        //cap.setCapability("name", "Test wallStreetJournal");
       // cap.setCapability("name", "sampletest");


        //Emulator testing
       // cap.setCapability("deviceName", "emulator-5554");
        //Device testing
//        cap.setCapability("deviceName", "e9b54af9");

        //cap.setCapability("app", "C:\\VAMSI\\Automation\\Mobile\\wsj.apk");
        //driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        //driver = new AndroidDriver( new URL("http://SAUCE_USERNAME:SAUCE_ACCESS_KEY@ondemand.saucelabs.com:80/wd/hub"), cap);
        try {
            //driver = new AndroidDriver(new URL("http://vamsipappala:1458f7e7-e261-4b56-873f-8df07be4c91e@ondemand.saucelabs.com:80/wd/hub"), cap);
            driver = new AndroidDriver(new URL("http://vamsipappala:1458f7e7-e261-4b56-873f-8df07be4c91e@ondemand.saucelabs.com/wd/hub"), cap);
            } catch (MalformedURLException e) {
                e.printStackTrace();
        }


    }

    @AfterClass
    public static void tearDown() {
        System.out.println("*********** Closing test Driver ***********");
        driver.quit();
        //Runtime.getRuntime().exec("adb -s emulator-5554 emu kill");
    }

    //Vertical Swipe by percentages
//    public void verticalSwipeByPercentages(double startPercentage, double endPercentage, double anchorPercentage) {
//        Dimension size = driver.manage().window().getSize();
//        int anchor = (int) (size.width * anchorPercentage);
//        int startPoint = (int) (size.height * startPercentage);
//        int endPoint = (int) (size.height * endPercentage);
//
//        new TouchAction(driver)
//                .press(point(anchor, startPoint))
//                .waitAction(waitOptix   ons(ofMillis(1000)))
//                .moveTo(point(anchor, endPoint))
//                .release().perform();
//    }

    //Touch swipe by
//    public static void swipeDown(MobileElement element) {
//        Point point = element.getLocation();
//        Dimension size = driver.manage().window().getSize();
//
////        int screenHeight = (int) (size.height * 0.90);
//        int screenHeight = (int) (size.height);
//        int elementY = point.getY();
//
//        int endX = 0;
//        int endY = ((int) screenHeight - elementY);
//
//        System.out.println("Device height:" + size.getHeight() + "******* Device width:" + size.getWidth());
//        System.out.println("Element X:" + point.getX() + "****** Element Y:" + point.getY());
//        System.out.println("Element Height:" + element.getSize().height + "****** Element Width:" + element.getSize().width);
//        System.out.println("end X:" + endX + "******** end Y:" + endY);
//
//        TouchAction actions = new TouchAction(driver);
//        actions.press(point(10, 10));
//        actions.moveTo(point(endX, endY));
//        actions.waitAction(waitOptions(Duration.ofMillis(250))).perform();
////
////        TouchAction action = new TouchAction((MobileDriver) driver);
////        action.press(
////                .getCenter().getX(), element.getCenter().getY()).moveTo(endX, screenHeight - element.getCenter().getY()).release().perform();
////        //action.press(MobileElement).moveTo(endX,endY).release().perform();
//    }



}
