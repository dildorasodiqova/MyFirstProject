package payme.g23.service.user;

import payme.g23.model.User;

import payme.g23.service.BaseService;
import payme.g23.util.Util;

public class UserServiceImpl implements BaseService, UserService {

    @Override
    public User signIn(String phoneNumber, String password) {
        return Util.USER_REPOSITORY.signIn(phoneNumber, password);
    }

    @Override
    public int add(User user) {
        return Util.USER_REPOSITORY.add(user);
    }
   @Override
    public int isBlock(User user) {
        return Util.USER_REPOSITORY.isBlock(user);
    }

  /*  @Override
    public int removeById(UUID uuid) {
        for (User user : USERS) {
            if (Objects.equals(user.getUuid(),uuid)){
                CardRepository.CARDS.remove(user);
                return 1;
            }
        }
        return -1;
    }
      @Override
       public ArrayList<User> getAllUsers() {
           ArrayList<User>users = new ArrayList<>();
           if(USERS.isEmpty()){
               return null ;
           }else {
               for (User user : USERS) {
                   if (!user.getRole().equals(Role.ADMIN)){
                       users.add(user);
                   }
               }
           }
           return users;
       }



  /*  public int add(User user) {

        for (User user1 : USERS) {
            if (Objects.equals(user1.getPhoneNumber(),user.getPhoneNumber())){
                return -1 ;
            }
        }
        user.setUuid(UUID.randomUUID());
        USERS.add(user);
        return 1 ;
    }

    @Override
    public ArrayList<User> showUnBlockUsers() {
        ArrayList<User> users = new ArrayList<>();

        for (User user : USERS) {
            if (user.getBlock() && (!user.getRole().equals(Role.ADMIN))){
                users.add(user);
            }
        }

        return users;
    }

    @Override
    public ArrayList<User> showBlockUsers() {
        ArrayList<User> users = new ArrayList<>();

        for (User user : USERS) {
            if (!user.getBlock() && (!user.getRole().equals(Role.ADMIN))){
                users.add(user);
            }
        }

        return users;
    }

    @Override
    public void unBlockUser(User userUnBlock) {
        userUnBlock.setBlock(true);
    }

    @Override
    public void blockUser(User user) {

        user.setBlock(false);

    }*/


}
