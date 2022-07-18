package com.citi.usermaintenance.process;

import com.citi.usermaintenance.config.AppConfig;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * XXXUserAction class contains selenium implementation
 */
@Slf4j
public class XXXUserAction implements UserAction {

    ChromeDriver driver;

    public XXXUserAction(){
        setChromeDriver();
    }


    public List<String> process(String user){

        log.info("Processing user={}, kill");
        refreshBrowser();

        driver.get(AppConfig.APP_URL);
        waitForPageLoad(driver);


        return Collections.emptyList();
    }

    public void refreshBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
        //d.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver(options);

        // disabled for testing
        //driver.manage().window().setPosition(new Point(-4000, -1000));
        log.info("Driver={}", driver);

        log.info("Driver initialised for processing={}", driver);


    }
}
