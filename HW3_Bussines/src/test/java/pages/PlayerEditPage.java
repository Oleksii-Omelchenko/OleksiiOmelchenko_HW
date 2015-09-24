package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Admin on 22.09.2015.
 */
public class PlayerEditPage {
    protected WebDriver driver;
    @FindBy(css = "input#ff14642ac1c__us_login")
    WebElement name;
    @FindBy(css = "input#ff14642ac1c__us_email")
    WebElement email;
    @FindBy(id = "ff14642ac1c__us_fname")
    WebElement firstName;
    @FindBy(id = "ff14642ac1c__us_lname")
    WebElement lastName;
    @FindBy(id = "ff14642ac1c__us_city")
    WebElement city;
    @FindBy(id = "ff14642ac1c__us_address")
    WebElement address;
    @FindBy(id = "ff14642ac1c__us_phone")
    WebElement phone;
    @FindBy(css = "select#ff14642ac1c__us_gender")
    WebElement gender;
    @FindBy(xpath = "//*[@id='c5618e27f0ab6d90d503b6ef5faca34c']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]")
    WebElement realMoneyCell;
    @FindBy(xpath = "//*[@id='c5618e27f0ab6d90d503b6ef5faca34c']/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]")
    WebElement funMoneyCell;
    @FindBy(xpath = "//*[@id='c5618e27f0ab6d90d503b6ef5faca34c']/table/tbody/tr[2]/td/table/tbody/tr[4]/td[2]")
    WebElement bonusDollarsCell;
    @FindBy(xpath = "//*[@id='c5618e27f0ab6d90d503b6ef5faca34c']/table/tbody/tr[2]/td/table/tbody/tr[5]/td[2]")
    WebElement loyaltyPointsCell;
    @FindBy(xpath = "//img[@alt='Add transaction']")
    WebElement addTransactionButton;
    @FindBy(xpath = "//input[@value='Save']")
    WebElement saveButton;

    public PlayerEditPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getActualName() {
        return name.getAttribute("value");
    }

    public String getActualEmail() {
        return email.getAttribute("value");
    }

    public String getActualFirstName() {
        return firstName.getAttribute("value");
    }

    public String getActualLastName() {
        return lastName.getAttribute("value");
    }

    public String getCity() {
        return city.getAttribute("value");
    }

    public String getAddress() {
        return address.getAttribute("value");
    }

    public String getPhone() {
        return phone.getAttribute("value");
    }

    public void clickSaveButton() {
        saveButton.click();
    }

    public void clickAddTransactionButton() {
        addTransactionButton.click();
    }

    public String getActualRealMoney() {
        return realMoneyCell.getText();
    }

    public String getActualFunMoney() {
        return funMoneyCell.getText();
    }

    public String getActualBonusDollars() {
        return bonusDollarsCell.getText();
    }

    public String getActualLoyaltyPoints() {
        return loyaltyPointsCell.getText();
    }
    public String getGender() {
        return new Select(gender).getFirstSelectedOption().getText();
    }

/* public String getGender() {
        return
    }
 */
}

