package payme.g23.service.transaction;

import payme.g23.model.Transaction;
import payme.g23.service.BaseService;

import java.util.ArrayList;
import java.util.UUID;

public interface TransactionService extends BaseService {
   // ArrayList<Transaction> getTransactionByCardId(UUID uuid);
    int add(Transaction transaction);
    ArrayList<Transaction> getAllTransaction();

    ArrayList<Transaction> betweenPerid(int year, int year2, int month, int month2, int day, int day2);
}
