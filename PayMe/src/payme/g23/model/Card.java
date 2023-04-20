package payme.g23.model;

import lombok.*;

import java.util.UUID;


public class Card {

    private String type ;
    private String cardNumber ;//16
    private String password ;
    private boolean isActive = true;
    private Double cardBalance = 1_000_000D;
    private UUID userID ;
    private UUID uuId = UUID.randomUUID();

    public Card(String type, String cardNumber, String password,UUID userId) {
        this.type = type;
        this.cardNumber = cardNumber;
        this.password = password;
        this.userID = userId;
    }

    public UUID getUuId() {
        return uuId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Double getCardBalance() {
        return cardBalance;
    }

    public void setCardBalance(Double cardBalance) {
        this.cardBalance = cardBalance;
    }

    public UUID getUserID() {
        return userID;
    }

    public void setUserID(UUID userID) {
        this.userID = userID;
    }

    public void setUuId(UUID uuId) {
        this.uuId = uuId;
    }
}
