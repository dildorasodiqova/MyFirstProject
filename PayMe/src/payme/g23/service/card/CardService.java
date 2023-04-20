package payme.g23.service.card;

import payme.g23.model.Card;
import payme.g23.service.BaseService;

import java.util.ArrayList;
import java.util.UUID;

public interface CardService extends BaseService {
   // ArrayList<Card> getCardById(UUID uuid);
    //Card getCardByNum(String num);
   // String transaction(Card cardOut, Card cardIn,Double amount);

    int add(Card card);

    ArrayList<Card> getMyCard(UUID uuid);
    ArrayList<Card> getCardIncome(UUID userId);
}
