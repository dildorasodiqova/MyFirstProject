package payme.g23.service.card;

import payme.g23.model.*;
import payme.g23.model.role.Role;
import payme.g23.repository.CardRepository;
import payme.g23.repository.UserRepository;
import payme.g23.service.BaseService;
import payme.g23.service.outcome.OutcomeService;
import payme.g23.service.outcome.OutcomeServiceImpl;
import payme.g23.util.Util;

import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;



public class CardServiceImpl implements CardService, BaseService {
 OutcomeService outcomeService = new OutcomeServiceImpl();

    @Override
    public int add(Card card) {
        return Util.CARD_REPOSITORY.add(card);
    }

    @Override
    public ArrayList<Card> getMyCard(UUID userId) {
        return Util.CARD_REPOSITORY.getMyCard(userId);
    }

    @Override
    public ArrayList<Card> getCardIncome(UUID userId) {
        return Util.CARD_REPOSITORY.getCardIncome(userId);
    }
  /*  @Override
    public Card getCardByNum(String num) {
        for (Card card : CardRepository.CARDS) {
            if (card.getCardNumber().equals(num)){
                return card ;
            }
        }
        return null ;
    }

    @Override
    public ArrayList<Card> getCardById(UUID uuid) {
        ArrayList<Card> cards = new ArrayList<>();
        for (Card card : CardRepository.CARDS) {
            if (card.getUserID().equals(uuid)){
                cards.add(card);
            }
        }
        return cards;
    }*/


/*
    @Override
    public String  transaction(Card cardOut, Card cardIn, Double amount) {

        for (User user : UserRepository.USERS) {
            if (user.getRole().equals(Role.ADMIN)){
                user.setAdminBalance(user.getAdminBalance() + amount * 0.02 );
            }
        }

        if (cardOut.getCardBalance() < amount + amount * 0.02){
            return"Not enough your money";
        }

        if (cardIn==null){
            return "Card not found !";
        }

        cardIn.setCardBalance(cardIn.getCardBalance()+amount);
        cardOut.setCardBalance(cardOut.getCardBalance()-amount  - amount * 0.02);

        Outcome outcome = new Outcome(cardOut.getUserID(),amount + amount * 0.02);
        outcomeService.add(outcome);

        Transaction history = new Transaction("Output ",cardIn.getCardNumber(),amount,cardOut.getUuid());
        BASE_SERVICE_HISTORY_SERVICE_MPL.add(history);
        Transaction history1 = new Transaction("Input ",cardOut.getCardNumber(),amount,cardIn.getUuid());
        BASE_SERVICE_HISTORY_SERVICE_MPL.add(history1);


        return "Successful transaction !";

    }*/

   /* @Override
    public int removeById(UUID uuid) {
        for (Card card : CardRepository.CARDS) {
            if (Objects.equals(card.getUuid(),uuid)){
                CardRepository.CARDS.remove(card);
                return 1;
            }
        }
        return -1;
    }*/
}
