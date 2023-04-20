package payme.g23.repository;

import payme.g23.model.User;

import java.util.ArrayList;

public interface UserRepository {

    int add(User user);

    User signIn(String phoneNumber, String password);

    int isBlock(User user);
}
