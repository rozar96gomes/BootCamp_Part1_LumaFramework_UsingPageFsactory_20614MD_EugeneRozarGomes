package com.qa.luma.TestBase;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.luma.Utilities.Util;

public class Luma_TestBase {

    public WebDriver driver;
    public ChromeOptions options;
    public FileInputStream ip;
    public Properties prop;
  

    public Luma_TestBase() throws Exception {
        prop = new Properties();
        ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\qa\\luma\\config\\configluma.properties");
        prop.load(ip);
    }

    public WebDriver initializeBrowserAndOpenApplication(String browserName) {
        if (browserName.equals("chrome")) {
            options = new ChromeOptions();
            options.setPageLoadStrategy(PageLoadStrategy.EAGER);
            options.addArguments("--start-maximized");
            options.addArguments("--incognito");
            options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation", "disable-infobars"));
            driver = new ChromeDriver(options);
        } else if (browserName.equals("edge")) {
            driver = new EdgeDriver();
            driver.manage().window().maximize();
        } else if (browserName.contains("firefox")) {
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Util.IMPLICIT_WAIT));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Util.PAGE_LOAD_TIME));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Util.SCRIPT_TIME));
        driver.get(prop.getProperty("url"));
        return driver;
    }
}
