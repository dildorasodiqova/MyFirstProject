package payme.g23.controller;

import payme.g23.model.Card;
import payme.g23.model.Transaction;
import payme.g23.model.User;
import payme.g23.util.Util;

import java.util.ArrayList;
import java.util.UUID;

import static payme.g23.util.Util.*;

public class UserUI {
    public static void userWindow(User user) {
        while (true) {
            System.out.println("1. CRUD card (card will not be deleted, isActive = false)\n" +
                    "2. P2P (peer to peer)\n" +
                    "3. History by Card");

            System.out.print("Choose  :");
            String choose = Util.SCANNER_STR.nextLine();

            switch (choose) {
                case "1":
                    addCard(user);
                    break;
                case "2":
                    myCards(user);
                    break;
                case "3":
                    transactionByCard(user);
                    break;
                case "0":
                    return;
            }
        }
    }

    private static void transactionByCard(User user) {
        System.out.println("1. Outcome\t2. Income\t0.back");
        int w = SCANNER_NUM.nextInt();
        switch (w) {
            case 1 -> {
                outcomeCard(user);
            }case 2 -> {
                incomeCard(user);
            }
        }
    }

    private static void incomeCard(User user) {
        CARD_SERVICE.getCardIncome(user.getUserId());
    }

    private static void outcomeCard(User user) {
        ArrayList<Card> outcomeCard = OUTCOME_SERVICE.getCardOutcome(user);
    }

    private static void addCard(User user) {
        System.out.print("Enter  card  type : ");
        String type = Util.SCANNER_STR.nextLine();
        System.out.print("Enter  kod :");
        String password = Util.SCANNER_STR.nextLine();
        System.out.println("Enter card number : ");
        String cardNumber = SCANNER_STR.nextLine();

        Card card = new Card(type, cardNumber, password, user.getUserId());
        int result = Util.CARD_SERVICE.add(card);
        if (result == 1) {
            System.out.println("☑️☑️");
        } else {
            System.out.println("\uD83D\uDD34\uD83D\uDD34");
        }
    }

    private static ArrayList<Card> myCards(User user) {
        ArrayList<Card> cards = Util.CARD_SERVICE.getMyCard(user.getUserId());
        int index = 1;
        for (Card card : cards) {
            System.out.println(index++ + " | " + card.getType() + "|| [CardNumber-> " + card.getCardNumber() +
                    "] || [Password-> " + card.getPassword() + "]" + " || [Balance-> " + card.getCardBalance() + "]");
        }
        return cards;
    }

   /* private static void fillBalance(User user) {
        ArrayList <Card> cards = myCards(user);
        System.out.print("1 Choose card");int index  = Util.SCANNER_NUM.nextInt();

        Card card = cards.get(--index);

        System.out.print("Enter amount : ");Double balance = Util.SCANNER_NUM.nextDouble();

        System.out.println("Before your balance : "+card.getCardBalance());
        card.setCardBalance(card.getCardBalance()+balance);
        Transaction history = new Transaction("Fill balance","",balance,card.getUuid());

        TRANSACTION_SERVICE.add(history);
        System.out.print("After  your balance : "+card.getCardBalance());
        System.out.println();

    }
*/
  /*  private static void transaction(User user) {
        ArrayList<Card> cards = myCards(user);
        System.out.print("Select the card to use : ");
        int index = Util.SCANNER_NUM.nextInt();
        Card cardOut = cards.get(--index);

        System.out.print("Enter recipient car number : ");
        String cardNum = Util.SCANNER_STR.nextLine();

        System.out.print("Amount to  be  transferred : ");
        Double amount = Util.SCANNER_NUM.nextDouble();

        Card cardIn = CARD_SERVICE.getCardByNum(cardNum);

        String result = CARD_SERVICE.transaction(cardOut,cardIn,amount);

        System.out.println(result);

    }
*/
  /*  private static void history(User user) {
        ArrayList <Card> cards = myCards(user);
        System.out.print("1 Choose card");int index  = Util.SCANNER_NUM.nextInt();

        Card card = cards.get(--index);

        ArrayList<Transaction> histories = TRANSACTION_SERVICE.getHistoryByCardId(card.getUuid());

        for (Transaction history : histories) {
            System.out.println(history.toString());
        }

    }*/
}
