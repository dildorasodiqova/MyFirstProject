package payme.g23.controller;

import payme.g23.model.Transaction;
import payme.g23.model.Outcome;
import payme.g23.model.User;
import payme.g23.util.Util;

import java.util.ArrayList;

import static payme.g23.util.Util.*;

public class AdminUI {
    public static void adminWindow(User user) {
        while (true){
            System.out.println("1.See Transactions\n2.Top 5 users (with outcoming transactions)\n0.exit");
            int a = SCANNER_NUM.nextInt();
            switch (a){
                case (1) -> {
                    seeTransaction(user);
                }case (2) -> {
                    topUsersOutcome(user);
                }case (0) -> {
                    System.out.println("exit");
                    return;
                }
            }
        }
    }

   private static void seeTransaction(User user) {
        System.out.println("1. all transaction\n" +
                "2. Between period\n" +
                "3. User's\n" +
                "0.back");
        int v = SCANNER_NUM.nextInt();
        switch (v){
            case (1) -> {
                allTransaction();
            }case (2) -> {
               // betweenPeriod();
            }case (3) -> {
                userTransaction();
            }case  (0) -> {
                return;
            }
        }
    }
    private static void allTransaction() {
        ArrayList<Transaction>transactions = TRANSACTION_SERVICE.getAllTransaction();
        int a = 0;
        for (Transaction tr : transactions) {
            System.out.println(a++ + "    " + tr.toString());
        }
    }

    private static void userTransaction() {
    }

   /* private static void betweenPeriod() {
        System.out.println(" enter the first date you want to see  ");
        System.out.print("Enter year -> ");
        int year = SCANNER_STR.nextInt();
        System.out.print("Enter month -> ");
        int month = SCANNER_STR.nextInt();
        System.out.print("Enter day -> ");
        int day = SCANNER_STR.nextInt();


        System.out.println("enter the second date you want to view");
        System.out.print("Enter year -> ");
        int year2 = SCANNER_STR.nextInt();
        System.out.print("Enter month -> ");
        int month2 = SCANNER_STR.nextInt();
        System.out.print("Enter day -> ");
        int day2 = SCANNER_STR.nextInt();
        ArrayList<Transaction> arrayList =  TRANSACTION_SERVICE.betweenPerid(year,year2,month,month2,day,day2);
        if (arrayList.isEmpty()){
            System.out.println("Not transaction");
        }else {
            for (Transaction transaction : arrayList) {
                System.out.println("Card Number  ||  " + transaction.getPlasticCardNum() + " \n " +
                        "Amount  || " + transaction.getAmount() + " \n " +
                        "Time  " + transaction.getWhen());
            }
        }

    }
*/
   /* private static void listOfUsers() {
        System.out.println();
        ArrayList<User>users = USER_SERVICE.getAllUsers();
        if (!users.isEmpty()){
            for (User user : users) {
                System.out.println(user.getName()+" "+user.getPhoneNumber());
            }
        }
        else {
            System.out.println("No users!");
        }
    }*/

    private static void topUsersOutcome(User user) {
        System.out.println("1. In week\n" +
                "2. In month\n0.back");
        int s = SCANNER_NUM.nextInt();
        switch (s) {
            case (1) -> {

            }
            case (2) -> {

            }
            case (0) -> {
                return;
            }
        }
       /* System.out.println("");
        User user2 = new User();
        ArrayList<Outcome> outcomes = OUTCOME_SERVICE.show();
       ArrayList<User> users = USER_SERVICE.getAllUsers();
        for (Outcome outcome : outcomes) {
            for (User user1 : users) {
                if (outcome.getOutcomeCardId().equals(user1.getUuid())){
                   user2 = user1;
                }
            }
            System.out.println(user2.getName()+"  " + user2.getPhoneNumber() + "  " + outcome.getAmount());
        }
    }

    private static void balance(User user) {
        System.out.println("Admin balance : "+user.getAdminBalance());
    }

/*  private static void blockOrUnblock() {
        while (true){
            System.out.println();
            System.out.println("""
                    1.Show block users
                    2.Show unblock users
                    3.Block user
                    4.Unblock user
                    0.Exit
                    Choose one :
                    """);
            String choose = SCANNER_STR.nextLine();
            switch (choose){
                case "0":return;
                case "1":showBlockUsers();break;
                case "2":showUnBlockUsers();break;
                case "3":blockUser();break;
                case "4":unBlockUser();break;
            }
        }
    }

   /* private static ArrayList<User> showBlockUsers() {
        ArrayList <User> users = USER_SERVICE_USER_SERVICE_IMPL.showBlockUsers();

        if (users.isEmpty()){
            System.out.println("No block users!");
        }else {
            for (User user : users) {
                System.out.println(user.getName()+ " " + user.getPhoneNumber());
            }
        }
        return users ;
    }

    private static ArrayList<User> showUnBlockUsers() {
        ArrayList <User> users = USER_SERVICE_USER_SERVICE_IMPL.showUnBlockUsers();

        if (users.isEmpty()){
            System.out.println("No unblock users!");
        }else {
            int index = 1 ;
            for (User user : users) {
                System.out.println(index++ +" "+user.getName()+" "+user.getPhoneNumber());
            }
        }
        return users ;
    }

    private static void blockUser() {
        ArrayList<User> users = showUnBlockUsers();

        System.out.print("Choose one user's index : ");
        int choose = SCANNER_NUM.nextInt();

        User userBlock = users.get(--choose);
        USER_SERVICE_USER_SERVICE_IMPL.blockUser(userBlock);
        System.out.println("Block user");

    }

    private static void unBlockUser() {
        ArrayList<User>users = showBlockUsers();

        System.out.print("Choose one user's index : ");
        int choose = SCANNER_NUM.nextInt();

        User userUnBlock = users.get(--choose);
        USER_SERVICE_USER_SERVICE_IMPL.unBlockUser(userUnBlock);
        System.out.println("Un block user");
    }*/
    }
}
