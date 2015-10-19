package objects;

/**
 * Created by Admin on 09.10.2015.
 */
public class BuilderPokerPlayer {
    private String name;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String city;
    private String address;
    private String phone;
    private String gender;
    private String realMoney;
    private String funMoney;
    private String bonusDollars;
    private String loyaltyPoints;
    private boolean payment;


    public BuilderPokerPlayer withName(String name) {
        this.name = name;
        return this;
    }

    public BuilderPokerPlayer withPassword(String password) {
        this.password = password;
        return this;
    }

    public BuilderPokerPlayer withEmail(String email) {
        this.email = email;
        return this;
    }

    public BuilderPokerPlayer withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public BuilderPokerPlayer withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public BuilderPokerPlayer withCity(String city) {
        this.city = city;
        return this;
    }

    public BuilderPokerPlayer withAddress(String address) {
        this.address = address;
        return this;
    }

    public BuilderPokerPlayer withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public BuilderPokerPlayer withGender(String gender) {
        this.gender = gender;
        return this;
    }

    public BuilderPokerPlayer withRealMoney(String realMoney) {
        this.realMoney = realMoney;
        return this;
    }

    public BuilderPokerPlayer withFunMoney(String funMoney) {
        this.funMoney = funMoney;
        return this;
    }

    public BuilderPokerPlayer withBonusDollars(String bonusDollars) {
        this.bonusDollars = bonusDollars;
        return this;
    }

    public BuilderPokerPlayer withLoyaltyPoints(String loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
        return this;
    }

    public BuilderPokerPlayer withPayment(boolean payment) {
        this.payment = payment;
        return this;
    }

    public PokerPlayer build() {
        return new PokerPlayer(name, email, password, firstName, lastName, city, address, phone, gender, realMoney, funMoney, bonusDollars, loyaltyPoints, payment);
    }
}
