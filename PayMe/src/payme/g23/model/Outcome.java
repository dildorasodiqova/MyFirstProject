package payme.g23.model;

import lombok.*;

import java.util.UUID;

public class Outcome {
    private UUID outcomeCardId;
    private UUID incomeCardId;
    private double amount;
    private UUID uuId = UUID.randomUUID();

    public Outcome(UUID outcomeCardId, UUID incomeCardId, double amount) {
        this.outcomeCardId = outcomeCardId;
        this.incomeCardId = incomeCardId;
        this.amount = amount;
    }

    public UUID getUuId() {
        return uuId;
    }

    public UUID getOutcomeCardId() {
        return outcomeCardId;
    }

    public void setOutcomeCardId(UUID outcomeCardId) {
        this.outcomeCardId = outcomeCardId;
    }

    public UUID getIncomeCardId() {
        return incomeCardId;
    }

    public void setIncomeCardId(UUID incomeCardId) {
        this.incomeCardId = incomeCardId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setUuId(UUID uuId) {
        this.uuId = uuId;
    }
}