package payme.g23.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import payme.g23.model.Card;
import payme.g23.model.Transaction;
import payme.g23.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public class CardRepositoryImpl implements CardRepository{
    String path = "C:\\Users\\HP\\Downloads\\Telegram Desktop\\PayMe (3)\\PayMe\\src\\payme\\g23\\file\\jsonCard.json";
    String pathTr = "C:\\Users\\HP\\Downloads\\Telegram Desktop\\PayMe (3)\\PayMe\\src\\payme\\g23\\file\\jsonTransaction.json";
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    @Override
    public int add(Card card) {
        ArrayList<Card> cards;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){
            cards = gson.fromJson(bufferedReader, new TypeToken<>() {});
            for (Card card1 : cards) {
                if (Objects.equals(card1.getUuId(),card.getUuId())){
                    return -1;
                }
            }
        } catch (IOException e){
            throw new RuntimeException(e);
        }

        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))){
            gson.toJson(cards, bufferedWriter);
        }catch (IOException e){
            throw new RuntimeException(e);
        }

        return 1;

    }

    @Override
    public ArrayList<Card> getMyCard(UUID userId) {
        ArrayList<Card> myCards = new ArrayList<>();
        ArrayList<Card> cards;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            cards = gson.fromJson(bufferedReader, new TypeToken<>() {
            });
            for (Card card1 : cards) {
                if (Objects.equals(card1.getUserID(), userId)) {
                    myCards.add(card1);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return myCards;
    }
//
//        ArrayList<User> users;
//        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){
//            users = gson.fromJson(bufferedReader, new TypeToken<>() {});
//            for (User u : users) {
//                if (Objects.equals(u.getPhoneNumber(),user.getPhoneNumber())){
//                    return -1;
//                }
//            }
//        } catch (IOException e){
//            throw new RuntimeException(e);
//        }

    @Override
    public ArrayList<Card> getCardOutcome(UUID userId) {
        ArrayList<Transaction> tr = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathTr))){
            ArrayList<Transaction> tr1 = gson.fromJson(bufferedReader, new TypeToken<ArrayList<Transaction>>() {
            });
            tr.addAll(tr1);

        } catch (IOException e){
            throw new RuntimeException(e);
        }

        ArrayList<Card> myCard = getMyCard(userId);

        ArrayList<Card> cards = new ArrayList<>();
        for (Transaction t : tr) {
            for (Card card1 : myCard) {
                if (Objects.equals(t.getCardOutcomeCardID(),card1.getUuId())){
                    cards.add(card1);
                }
            }

        }
        return cards;

    }
    public ArrayList<Card> getCardIncome(UUID userId) {
        ArrayList<Transaction> tr = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathTr))){
            ArrayList<Transaction> tr1 = gson.fromJson(bufferedReader, new TypeToken<ArrayList<Transaction>>() {
            });
            tr.addAll(tr1);

        } catch (IOException e){
            throw new RuntimeException(e);
        }

        ArrayList<Card> myCard = getMyCard(userId);

        ArrayList<Card> cards = new ArrayList<>();
        for (Transaction t : tr) {
            for (Card card1 : myCard) {
                if (Objects.equals(t.getCardIncomeCardId(),card1.getUuId())){
                    cards.add(card1);
                }
            }

        }
        return cards;

    }
}

