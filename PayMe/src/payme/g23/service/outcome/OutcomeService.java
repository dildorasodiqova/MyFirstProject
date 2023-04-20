package payme.g23.service.outcome;

import payme.g23.model.Card;
import payme.g23.model.Outcome;
import payme.g23.model.User;

import java.util.ArrayList;

public interface OutcomeService {
     void add(Outcome outcome);
     void top5Users();

     ArrayList<Outcome> show();
     void compareUserOutcome();

    ArrayList<Card> getCardOutcome(User user);
}
