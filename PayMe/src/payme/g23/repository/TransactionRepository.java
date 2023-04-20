package payme.g23.repository;

import payme.g23.model.Transaction;

import java.util.ArrayList;
import java.util.UUID;

public interface TransactionRepository {
    ArrayList<Transaction> TRANSACTION_ARRAY_LIST = new ArrayList<>();

    ArrayList<Transaction> getAllTransaction();

   /* ArrayList<Transaction> getTransactioonByCardID(UUID userId);*/

    int add(Transaction transaction);

    ArrayList<Transaction> betweenPeriod(int year, int year2, int month, int month2, int day, int day2);
}
