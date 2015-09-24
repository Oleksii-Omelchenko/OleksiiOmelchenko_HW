package logic;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 24.09.2015.
 */
public class Asserts {
    public WebDriver driver;
    List<String> listOfAsserts = new ArrayList<String>();
    public Asserts(WebDriver driver) {
        listOfAsserts.clear();
        this.driver = driver;
    }


}
