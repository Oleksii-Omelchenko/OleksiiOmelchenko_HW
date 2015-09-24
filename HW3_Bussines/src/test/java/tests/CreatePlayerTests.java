package tests;

import logic.Base;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Admin on 21.09.2015.
 */
public class CreatePlayerTests {

    //test values
    DateFormat nameCore = new SimpleDateFormat("MMddHHmmss");
    Date date = new Date();
    protected String expectedName = "a" + String.valueOf(nameCore.format(date));
    protected String playersPassword = "Password";
    protected String expectedPlayersEmail = (expectedName + "@test.com");
    protected String expectedFirstName = expectedName + "first";
    protected String expectedLastName = expectedName + "last";
    protected String expectedCity = expectedName + "city";
    protected String expectedAddress = expectedName + "adress";
    protected String expectedPhone = "+038";
    protected String expectedGender = "Male";
    protected String expectedPlayerBalance = "0.00";
    protected String expectedFunBalance = "1,000.00";


    @Test
    public void testCreatePlayer() throws InterruptedException {
        Base base = new Base();
        base.enter();
        base.createPlayerAction();
        base.insertPlayerAction(expectedName, playersPassword, expectedPlayersEmail, expectedFirstName,
                expectedLastName, expectedCity, expectedAddress, expectedPhone, expectedGender, expectedPlayerBalance, expectedFunBalance);
        base.findNewPlayerAction(expectedPlayersEmail);
        String actualName = base.getActualName;
        String actualEmail = base.getActualEmail;
        String actualFirstName = base.getActualFirstName;
        String actualLastName = base.getActualLastName;
        String actualCity = base.getActualCity;
        String actualAddress = base.getActualAddress;
        String actualPhone = base.getActualPhone;
        String actualGender = base.getActualGender;
        //base.exit();


        // check results
        Assert.assertEquals(actualName, expectedName);
        Assert.assertEquals(actualEmail, expectedPlayersEmail);
        Assert.assertEquals(actualFirstName, expectedFirstName);
        Assert.assertEquals(actualLastName,expectedLastName);
        Assert.assertEquals(actualCity, expectedCity);
        Assert.assertEquals(actualAddress, expectedAddress);
        Assert.assertEquals(actualPhone, expectedPhone);
        Assert.assertEquals(actualGender,expectedGender);
        /*Assert.assertEquals(actualPlayerBalance, expectedPlayerBalance);
        Assert.assertEquals(actualFunBalance, expectedFunBalance);*/


    }
}
