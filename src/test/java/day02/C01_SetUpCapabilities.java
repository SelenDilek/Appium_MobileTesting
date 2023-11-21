package day02;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class C01_SetUpCapabilities {

    //Set-up Appium Environments

    //1st step : Create androidDriver from the Android class

    AndroidDriver<AndroidElement> androidDriver;

    //2nd step : Create capabilities object from the DesriedCapabilities class
    DesiredCapabilities capabilities = new DesiredCapabilities();

    /*
           Why do we need to use capability?
           1- we should define name of the emulator, operating system, url, automation name, application name
           2-Capabilities are working as a key-value
         */

    @Test
    public void setUpCalculator() throws MalformedURLException {

        capabilities.setCapability("deviceName","Pixel 2 API 30");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("platformVersion","11.0");
        capabilities.setCapability("automationName","UiAutomator2");
        //Download an application from the apkPure
        //create a directory with name app under the project name then drag and drop the downloaded app.
        capabilities.setCapability("app",System.getProperty("user.dir")+"/app/Calculator.apk");
        //set-up driver and define implement the url (android inspector)
        androidDriver= new AndroidDriver<>(new URL("http://127.0.0.1:4723"),capabilities);
        //run etmeden once CMD appium --use-plugins=element-wait

    }

}
