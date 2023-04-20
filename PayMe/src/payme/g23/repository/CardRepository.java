package payme.g23.repository;

import payme.g23.model.Card;

import java.util.ArrayList;
import java.util.UUID;

public interface CardRepository {
    ArrayList<Card> CARDS = new ArrayList<>();

    int add(Card card);

    ArrayList<Card> getMyCard(UUID userId);

    ArrayList<Card> getCardOutcome(UUID uuid);
    public ArrayList<Card> getCardIncome(UUID userId);
}
