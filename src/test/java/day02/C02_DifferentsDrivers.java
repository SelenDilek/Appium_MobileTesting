package day02;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class C02_DifferentsDrivers {
    //If we only test on the Android APPS, it is suggested to use AndroidDriver
    //If we test Android and IOS apps we should use AppiumDriver
    //If you will not test ios apps no need to use AppiumDriver

    AndroidDriver<MobileElement> appiumDriver;

    DesiredCapabilities capabilities = new DesiredCapabilities();
    @Test
    public void isCalculatorAppInstalled() throws MalformedURLException {

        capabilities.setCapability("deviceName","Pixel 2 API 30");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("platformVersion","11.0");
        capabilities.setCapability("automationName","UiAutomator2");
        capabilities.setCapability("app",System.getProperty("user.dir")+"/app/Calculator.apk");
        appiumDriver= new AndroidDriver<>(new URL("http://127.0.0.1:4723"),capabilities);
        //run etmeden once CMD appium --use-plugins=element-wait
        //to test for  is AppInstalled we should find the bundled of the application
        //download Apk info from the apk pure website
        Assert.assertTrue(appiumDriver.isAppInstalled("com.google.android.calculator"));

    }
    /*
    Node,js kullaniyorsaniz, Java nin MobileCapabilityType ni dogrudan access yoktur
    Bu sebeple hata alinma riski olabilir
     */

    @Test
    public void capabiliyTypes() throws MalformedURLException {


        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 2 API 30");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.VERSION,"11.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP,System.getProperty("user.dir")+"/app/Calculator.apk");
        appiumDriver= new AndroidDriver<>(new URL("http://127.0.0.1:4723"),capabilities);




    }

}
