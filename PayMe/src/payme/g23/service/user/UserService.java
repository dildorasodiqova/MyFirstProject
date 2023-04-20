package payme.g23.service.user;

import payme.g23.model.User;
import payme.g23.service.BaseService;

import java.util.ArrayList;

public interface UserService extends BaseService {
    User signIn(String phoneNumber , String password);
    int add(User user);
   int isBlock(User user);

  //  ArrayList<User> getAllUsers();
   /* ArrayList<User>getAllUsers();
  /*  ArrayList<User>showBlockUsers();
    ArrayList<User>showUnBlockUsers();
    void blockUser(User user);
    void unBlockUser(User userUnBlock);*/
}
