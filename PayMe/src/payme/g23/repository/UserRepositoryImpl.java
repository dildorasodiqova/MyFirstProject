package payme.g23.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import payme.g23.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class UserRepositoryImpl implements UserRepository{
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    String path = "C:\\Users\\HP\\Downloads\\Telegram Desktop\\PayMe (3)\\PayMe\\src\\payme\\g23\\file\\jsonUser.json";

    @Override
    public int add(User user) {
        ArrayList<User> users;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){
            users = gson.fromJson(bufferedReader, new TypeToken<>() {});
            for (User u : users) {
                if (Objects.equals(u.getPhoneNumber(),user.getPhoneNumber())){
                    return -1;
                }
            }
        } catch (IOException e){
            throw new RuntimeException(e);
        }

        users.add(user);

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))){
            gson.toJson(users, bufferedWriter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return 1;
    }

    @Override
    public User signIn(String phoneNumber, String password) {
        ArrayList<User> userArrayList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){
            userArrayList.addAll(gson.fromJson(bufferedReader, new TypeToken<ArrayList<User>>() {}));
        } catch (IOException e){
            throw new RuntimeException(e);
        }
        for (User user : userArrayList) {
            if (Objects.equals(user.getPhoneNumber(),phoneNumber) &&
                    (Objects.equals(user.getPassword(),password))){
                return user;
            }

        }
        return null;
    }

    @Override
    public int isBlock(User user) {
        ArrayList<User> userArrayList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){
            userArrayList.addAll(gson.fromJson(bufferedReader, new TypeToken<ArrayList<User>>() {}));
        } catch (IOException e){
            throw new RuntimeException(e);
        }
        for (User user1 : userArrayList) {
            if (user1.getBlock()){
                return 1;
            }
        }
        return -1;
    }

  /*  @Override
    public int isBlock(User user) {
        ArrayList<User> userArrayList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){
            userArrayList.addAll(gson.fromJson(bufferedReader, new TypeToken<ArrayList<User>>() {}));
        }catch (FileNotFoundException e){
            throw new RuntimeException(e);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        for (User user1 : userArrayList) {
            if (user1.getBlock()){
                return 1;
            }
        }
        return -1;
    }*/
}
