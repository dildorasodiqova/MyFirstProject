package payme.g23.controller;

import payme.g23.model.User;
import payme.g23.model.role.Role;
import payme.g23.service.user.UserService;
import payme.g23.util.Util;

import javax.sound.midi.Soundbank;

import java.util.Objects;

import static payme.g23.model.role.Role.USER;


public class MainUI {
    public static void runWindow() {
        while (true){
            System.out.println("1 . Sign Up");
            System.out.println("2 . Sign In");
            System.out.println("0 . Exit");
            System.out.print("Choose : ");
            String choose = Util.SCANNER_STR.nextLine();

            switch (choose){
                case "1" : signUp() ; break;
                case "2" : signIn() ; break;
                case "0" : return;
            }
        }
    }

    private static void signUp() {
        System.out.print("Enter     your     name : ");String name = Util.SCANNER_STR.nextLine();
        System.out.print("Enter your phone number : ");String phoneNumber = Util.SCANNER_STR.nextLine();
        System.out.print("Enter    your  password : ");String password = Util.SCANNER_STR.nextLine();
        User user = new User(name,phoneNumber,password);
        int result = Util.USER_SERVICE.add(user);
        if (result==1){
            System.out.println("☑️☑️");
        }else {
            System.out.println("\uD83D\uDD34\uD83D\uDD34");
        }

    }

    private static void signIn() {
        System.out.print("Enter your phone number : ");String phoneNumber = Util.SCANNER_STR.nextLine();
        System.out.print("Enter   your   password : ");String password = Util.SCANNER_STR.nextLine();

        User user = Util.USER_SERVICE.signIn(phoneNumber,password);
        if (user == null){
            System.out.println("\uD83D\uDD34\uD83D\uDD34");
            return;
        }
        int result = Util.USER_SERVICE.isBlock(user);
        if (result==1) {
            if (Objects.equals(user.getRole(),"USER")) {
                UserUI.userWindow(user);
            } else {
                AdminUI.adminWindow(user);
            }
        }else {
            System.out.println("You block \uD83D\uDD34");
        }


    }
}
