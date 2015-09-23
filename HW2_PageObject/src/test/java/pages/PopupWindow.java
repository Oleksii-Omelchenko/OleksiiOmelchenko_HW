package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Admin on 22.09.2015.
 */
public class PopupWindow {
    protected WebDriver driver;
    @FindBy(css = "#f6ffb4a0fec__account")
    WebElement account;
    @FindBy(css = "#f6ffb4a0fec__direction")
    WebElement direction;
    @FindBy(css = "#f6ffb4a0fec__amount")
    WebElement amount;
    @FindBy(css = "css=#f6ffb4a0fec__notes")
    WebElement notes;
    @FindBy(css = ".form_actions_container>input[value=\"Save\"]")
    WebElement saveButton;

    public PopupWindow(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
   /*
   public void selectAccount(){
        Select(account).getFirstSelectedOption().getText();
   public void selectDirection(){
        Select(direction).getFirstSelectedOption().getText();
        */
   public void setAmount(String expectedAmount){
       amount.sendKeys(expectedAmount);

   }
    public void setDirection(String expectedDirection) {
        amount.sendKeys(expectedDirection);
    }
    public void clickSaveButton(){
        saveButton.click();
    }
}

