package tools;

import org.openqa.selenium.WebDriver;

/**
 * Created by Admin on 13.10.2015.
 */
public class Tools {
    WebDriver driver;
    public void waitForPageToLoad(WebDriver driver){
        driver.manage().window().maximize();
        //driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
    }
    }

