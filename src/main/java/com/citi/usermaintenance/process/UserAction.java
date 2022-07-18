package com.citi.usermaintenance.process;

import com.citi.usermaintenance.config.AppConfig;
import com.google.common.base.Predicate;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


/**
 * UserAction interface contains the base functions for the selenium interaction
 */
public interface UserAction {

    default void wait(WebDriver driver, By webElement, int seconds){

        new WebDriverWait(driver, seconds).until(
            ExpectedConditions.visibilityOfElementLocated(webElement));

    }

    default void close(WebDriver driver){
        try {
            driver.close();
        }catch(Exception ex){

        }
    }

    default void waitForPageLoad(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 50);

        Predicate<WebDriver> pageLoaded = new Predicate<WebDriver>() {

            @Override
            public boolean apply(WebDriver input) {
                return ((JavascriptExecutor) input).executeScript("return document.readyState").equals("complete");
            }

        };
        wait.until(pageLoaded);
    }

    default void setChromeDriver(){
        String chromeDriver = AppConfig.CHROME_DRIVER;
//        if(new File(chromeDriver).exists()){
//            throw new RuntimeException("Chrome driver not found at path: " +  chromeDriver);
//        }

        System.setProperty("webdriver.chrome.driver",chromeDriver);
    }

    List<String> process(String fileName);
}
