package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Admin on 21.09.2015.
 */
public class PlayersPage {
    protected WebDriver driver;

    @FindBy(xpath = "//a[text()='Insert']")
    WebElement insertPlayerButton;
    @FindBy(id = "723a925886__email")
    WebElement searchByEmailCell;
    @FindBy(xpath = "//input[@value='Search']")
    WebElement searchButton;
    @FindBy(css ="img[alt='Edit']")
    WebElement editButton;
    @FindBy(xpath = "//parent::tbody/child::tr[position()=2]/child::td[position()=6]")
    WebElement playerBalanceCell;
    @FindBy(xpath = "//a[img [@alt='logout']][span[@class='logout']]")
    WebElement logout;
    @FindBy(xpath = "//parent::tbody/child::tr[position()=2]/child::td[position()=7]")
    WebElement playerFunBalanceCell;



    public PlayersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PlayersInsertPage clickInsertButton() {
        insertPlayerButton.click();
        return new PlayersInsertPage(driver);
    }

    public void setSearchByEmailCell(String email) {
        searchByEmailCell.sendKeys(email);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public PlayerEditPage clickEditButton() {
        editButton.click();
        return new PlayerEditPage(driver);
    }

    public String getActualPlayerBalance() {
        return playerBalanceCell.getAttribute("value");
    }

    public String getActualPlayerFunBalance() {
        return playerFunBalanceCell.getAttribute("value");
    }

    public void clickLogout() {
        logout.click();
    }

}
