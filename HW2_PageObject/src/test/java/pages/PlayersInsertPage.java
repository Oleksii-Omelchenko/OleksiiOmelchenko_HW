package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Admin on 21.09.2015.
 */
public class PlayersInsertPage {
    protected WebDriver driver;
    @FindBy(id="ff14642ac1c__us_login")
    WebElement name;
    @FindBy(xpath = "//input[@id='ff14642ac1c__us_email']")
    WebElement email;
    @FindBy(xpath = "//input[@id='ff14642ac1c__us_password']")
    WebElement password;
    @FindBy(xpath = "//input[@id='ff14642ac1c__confirm_password']")
    WebElement confirmPlayersPassword;
    @FindBy(css = "input[id='ff14642ac1c__us_fname']")
    WebElement firstName;
    @FindBy(css = "input[id='ff14642ac1c__us_lname']")
    WebElement lastName;
    @FindBy(css = "input[id='ff14642ac1c__us_city']")
    WebElement city;
    @FindBy(css = "textarea[id='ff14642ac1c__us_address']")
    WebElement address;
    @FindBy(id = "ff14642ac1c__us_phone")
    WebElement phone;
    @FindBy(css = "select[id='ff14642ac1c__us_gender']")
    WebElement gender;
    @FindBy(xpath = "//input[@value='Save']")
    WebElement saveButton;
    public PlayersInsertPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setName(String expectedName) {
        name.sendKeys(expectedName);
    }

    public void setEmail(String expectedEmail) {
        email.sendKeys(expectedEmail);
    }

    public void setPlayersPassword(String playersPassword) {
        password.sendKeys(playersPassword);
    }

    public void setConfirmPlayersPassword(String playersPassword) {
        confirmPlayersPassword.sendKeys(playersPassword);
    }

    public void setFirstName(String expectedFirstName) {
        firstName.sendKeys(expectedFirstName);
    }

    public void setLastName(String expectedLastName) {
        lastName.sendKeys(expectedLastName);
    }

    public void setCity(String expectedCity) {
        city.sendKeys(expectedCity);
    }

    public void setAddress(String expectedAddress) {
        address.sendKeys(expectedAddress);
    }

    public void setPhone(String expectedPhone) {
        phone.sendKeys(expectedPhone);
    }

    public void clickSaveButton() {
        saveButton.click();
    }

    /* допилить метод
    Select select = new Select(gender);
    select.deselect();
        select.selectByVisibleText(gender);
    /*public selectGender(){
        new SelectSelect(gender).getFirstSelectedOption().getText();
    }*/
   public String getGender() {
        return new Select(gender).getFirstSelectedOption().getText();
    }
    //public String expectedGender = this.getGender();

    }
