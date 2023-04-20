package payme.g23;
import payme.g23.controller.MainUI;
import payme.g23.model.Card;
import payme.g23.model.User;
import payme.g23.model.role.Role;

import static payme.g23.util.Util.*;

public class Main {
    static {
        User user1 = new User("d","11","11");
        USER_SERVICE.add(user1);
        Card cardUser1 = new Card("a","22","22",user1.getUserId());
        CARD_SERVICE.add(cardUser1);

        User user2 = new User("s","33","33");
        USER_SERVICE.add(user2);
        Card cardUser2 = new Card("humo","444","444",user2.getUserId());
        CARD_SERVICE.add(cardUser2);

        User user3 = new User("Xasan","555","555","ADMIN");
        USER_SERVICE.add(user3);
        Card cardUser3 = new Card("humo","666","666",user3.getUserId());
        CARD_SERVICE.add(cardUser3);


    }
    public static void main(String[] args) {
        MainUI.runWindow();
    }
}
