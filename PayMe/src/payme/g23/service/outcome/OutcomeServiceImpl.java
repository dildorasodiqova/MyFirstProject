package payme.g23.service.outcome;

import payme.g23.model.Card;
import payme.g23.model.Outcome;
import payme.g23.model.User;
import payme.g23.repository.OutcomeRepository;
import payme.g23.util.Util;

import java.util.ArrayList;

public class OutcomeServiceImpl implements OutcomeService, OutcomeRepository {
   public void add(Outcome outcome){

   }
   @Override
   public ArrayList<Card> getCardOutcome(User user) {
      return Util.CARD_REPOSITORY.getCardOutcome(user.getUserId());
   }

   @Override
   public void top5Users() {

   }

   @Override
   public ArrayList<Outcome> show() {
     return OUTCOMES_5_top;
   }

   @Override
   public void compareUserOutcome() {
      Outcome maxx =  OUTCOME_ARRAY_LIST.get(0) ;
      for (int j = 0; j < 5 ; j++){
         for (int i = 1; i < OUTCOME_ARRAY_LIST.size(); i++) {
            if (maxx.getAmount() > OUTCOME_ARRAY_LIST.get(i).getAmount()){
               maxx = OUTCOME_ARRAY_LIST.get(i);
            }
         }
         OUTCOMES_5_top.add(maxx);
         maxx.setAmount(0D);
      }
   }



}
