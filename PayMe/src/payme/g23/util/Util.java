package payme.g23.util;

import payme.g23.repository.*;
import payme.g23.service.BaseService;
import payme.g23.service.card.CardService;
import payme.g23.service.card.CardServiceImpl;


import payme.g23.service.outcome.OutcomeService;
import payme.g23.service.outcome.OutcomeServiceImpl;
import payme.g23.service.transaction.TransactionService;
import payme.g23.service.transaction.TransactionServiceImpl;
import payme.g23.service.user.UserService;
import payme.g23.service.user.UserServiceImpl;

import java.util.Scanner;

public interface Util {
    Scanner SCANNER_STR = new Scanner(System.in);
    Scanner SCANNER_NUM = new Scanner(System.in);
    CardService  CARD_SERVICE = new CardServiceImpl();
    CardRepository CARD_REPOSITORY = new CardRepositoryImpl();
    TransactionService TRANSACTION_SERVICE = new TransactionServiceImpl();
    TransactionRepository transactionRepository = new TransactionRepositoryImpl();
    UserService USER_SERVICE = new UserServiceImpl();
    UserRepository USER_REPOSITORY =  new UserRepositoryImpl();
    OutcomeService OUTCOME_SERVICE = new OutcomeServiceImpl();
    OutcomeRepository OUTCOME_REPOSITORY = new OutcomeRepositoryImpl();





}
