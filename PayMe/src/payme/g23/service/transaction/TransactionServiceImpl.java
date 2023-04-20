package payme.g23.service.transaction;

import payme.g23.model.Transaction;
import payme.g23.service.BaseService;
import payme.g23.util.Util;

import java.util.ArrayList;


public class TransactionServiceImpl implements BaseService ,TransactionService {

  /*  public ArrayList<Transaction> getAllTransaction() {
       // ArrayList<Transaction> transactions = new ArrayList<>();
        return Util.transactionRepository.getAllTransaction();
    }

    @Override
    public ArrayList<Transaction> getTransactionByCardId(UUID userId) {
        return Util.transactionRepository.getTransactioonByCardID(userId);
//        ArrayList<Transaction> histories = new ArrayList<>();
//        for (Transaction history : HISTORIES) {
//            if (history.getCardUUid().equals(uuid)){
//                histories.add(history);
//            }
//        }
//        return histories;

    }*/


    @Override
    public int add(Transaction transaction) {
        return Util.transactionRepository.add(transaction);
    }

    @Override
    public ArrayList<Transaction> getAllTransaction() {
        return Util.transactionRepository.getAllTransaction();
    }

    @Override
    public ArrayList<Transaction> betweenPerid(int year, int year2, int month, int month2, int day, int day2) {
        return Util.transactionRepository.betweenPeriod(year,year2,month,month2,day,day2);
    }

  /*  @Override
    public int removeById(UUID uuid) {
        return 0;
    }*/
}
