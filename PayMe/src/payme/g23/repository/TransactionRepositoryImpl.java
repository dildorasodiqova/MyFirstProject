package payme.g23.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import payme.g23.model.Transaction;

import java.io.*;
import java.util.ArrayList;
import java.util.UUID;

public class TransactionRepositoryImpl implements TransactionRepository{
    String path = "C:\\Users\\HP\\Downloads\\Telegram Desktop\\PayMe (3)\\PayMe\\src\\payme\\g23\\file\\jsonTransaction.json";
   Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public ArrayList<Transaction> getAllTransaction() {
        ArrayList<Transaction> transactions = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){
             transactions.addAll( gson.fromJson(bufferedReader, new TypeToken<ArrayList<Transaction>>() {}));

        }catch (FileNotFoundException e){
            throw new RuntimeException(e);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        return transactions;
    }

    @Override
    public int add(Transaction transaction) {
        String json = gson.toJson(transaction);
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))){
            bufferedWriter.write(json);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        return 1;
    }

    @Override
    public ArrayList<Transaction> betweenPeriod(int year, int year2, int month, int month2, int day, int day2) {
        ArrayList<Transaction> arrayList = new ArrayList<>();
        for (Transaction transaction : getAllTransaction()) {
            int year1 = transaction.getWhen().getYear();
            int month1 = transaction.getWhen().getMonth();
            int day1 = transaction.getWhen().getDay();
            if ((year1 >= year && year1 <= year2) || (month >= month1 && month1 <= month2) || (day >= day1 && day1 <= day2)){
                arrayList.add(transaction);
            }
        }
        return arrayList;
    }

  /*  @Override
    public ArrayList<Transaction> getTransactionByCardID(UUID userId) {
        ArrayList<Transaction> allTransaction = getAllTransaction();
        ArrayList<Transaction> transactionArrayList = new ArrayList<>();
        for (Transaction tr : allTransaction ) {
            if (tr.getCardUUid().equals()){
                transactionArrayList.add(tr);
            }
        }
        return transactionArrayList;
    }*/
}
