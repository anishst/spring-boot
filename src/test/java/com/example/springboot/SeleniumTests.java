package com.example.springboot;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumTests {

        public static void main(String[] args) throws MalformedURLException {
            // TODO Auto-generated method stub
            //https://medium.com/chaya-thilakumara/selenium-grid-chrome-browser-c2cb986e0f70

            // use docker driver
            DesiredCapabilities cap=new DesiredCapabilities();
            cap.setBrowserName("chrome");
            cap.setPlatform(Platform.LINUX);
            ChromeOptions options = new ChromeOptions();
            options.setHeadless(true);
            //   merger desired capabilities with the chrome options.
            options.merge(cap);

            String hub_url ="http://192.168.1.25:4444/wd/hub";
            WebDriver driver=new RemoteWebDriver(new URL(hub_url), options);

            // local chrome driver
//            WebDriver driver = new ChromeDriver();
            driver.get("http://192.168.1.25:8081/");
            System.out.println(driver.getPageSource());
            driver.quit();
        }


}
