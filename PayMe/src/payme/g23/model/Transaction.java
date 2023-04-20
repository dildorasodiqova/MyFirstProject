package payme.g23.model;


import lombok.*;

import java.util.Date;
import java.util.UUID;


public class Transaction{

    private String operation;
    private String plasticCardNum; // association
    private Double amount;
    private UUID cardOutcomeCardID;
    private UUID cardIncomeCardId;
    private Date when = new Date();
    private UUID uuId = UUID.randomUUID();
    public String getPlasticCardNum() {
        return plasticCardNum;
    }

    public Double getAmount() {
        return amount;
    }

    public Date getWhen() {
        return when;
    }

    public Transaction(String operation, String plasticCardNum, Double amount, UUID cardOutcomeCardID, UUID cardIncomeCardId, Date when) {
        this.operation = operation;
        this.plasticCardNum = plasticCardNum;
        this.amount = amount;
        this.cardOutcomeCardID = cardOutcomeCardID;
        this.cardIncomeCardId = cardIncomeCardId;
        this.when = when;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setPlasticCardNum(String plasticCardNum) {
        this.plasticCardNum = plasticCardNum;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public UUID getCardOutcomeCardID() {
        return cardOutcomeCardID;
    }

    public void setCardOutcomeCardID(UUID cardOutcomeCardID) {
        this.cardOutcomeCardID = cardOutcomeCardID;
    }

    public UUID getCardIncomeCardId() {
        return cardIncomeCardId;
    }

    public void setCardIncomeCardId(UUID cardIncomeCardId) {
        this.cardIncomeCardId = cardIncomeCardId;
    }

    public void setWhen(Date when) {
        this.when = when;
    }

    public UUID getUuId() {
        return uuId;
    }

    public void setUuId(UUID uuId) {
        this.uuId = uuId;
    }
}
