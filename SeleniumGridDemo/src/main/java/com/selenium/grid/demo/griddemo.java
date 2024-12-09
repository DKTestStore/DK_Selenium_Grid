package com.selenium.grid.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class griddemo {

    private static WebDriver driver;

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        launchBrowser();
        System.out.println("Execution is Completed by Main method");
    }

    public static void launchBrowser() throws MalformedURLException, InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.setCapability("browserVersion", "latest");
        options.setCapability("platformName", "Windows");

        // Update the URL based on your Selenium Grid Hub configuration
        String hubUrl = "http://192.168.0.103:4444/wd/hub";
        driver = new RemoteWebDriver(new URL(hubUrl), options);

        navigateToUrl("https://www.google.com");
        Thread.sleep(5000);

        // Close the browser after the test
        if (driver != null) {
            driver.quit();
        }
    }

    public static void navigateToUrl(String url) {
        if (driver != null) {
            driver.get(url);
        }
    }
}
