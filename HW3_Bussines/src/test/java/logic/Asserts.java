package logic;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

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
        this.driver = this.driver;
    }
    public void assertEquals(String actualValue, String expectedValue) {
        try {
            Assert.assertEquals(actualValue, expectedValue);
        } catch (AssertionError e) {
            listOfAsserts.add(e.getMessage());
        }
    }

    public void printErrors(){

        if (!listOfAsserts.isEmpty()) {
            for (String s: listOfAsserts) {
                System.out.println(s + "\n");
            }
            Assert.fail();
        }

}
}
