package objects;

/**
 * Created by Admin on 09.10.2015.
 */
public class PokerPlayer {
    public String playerName;
    public String playerEmail;
    public String playerPassword;
    public String playerFirstName;
    public String playerLastName;
    public String playerCity;
    public String playerAddress;
    public String playerPhone;
    public String playerGender;
    public String playerRealMoney;
    public String playerFunMoney;
    public String playerBonusDollars;
    public String playerLoyaltyPoints;
    public boolean payment;

    public PokerPlayer(String playerName, String playerEmail, String playerPassword,String playerFirstName, String playerLastName,
                       String playerCity, String playerAddress, String playerPhone, String playerGender, String playerRealMoney,
                       String playerFunMoney, String playerBonusDollars, String playerLoyaltyPoints, boolean payment){
        this.playerName = playerName;
        this.playerEmail = playerEmail;
        this.playerPassword = playerPassword;
        this.playerFirstName = playerFirstName;
        this.playerLastName = playerLastName;
        this.playerCity = playerCity;
        this.playerAddress = playerAddress;
        this.playerPhone = playerPhone;
        this.playerGender = playerGender;
        this.playerRealMoney = playerRealMoney;
        this.playerFunMoney = playerFunMoney;
        this.playerBonusDollars = playerBonusDollars;
        this.playerLoyaltyPoints = playerLoyaltyPoints;
        this.payment = payment;

    }

}
