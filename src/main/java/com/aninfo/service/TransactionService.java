package com.aninfo.service;

import com.aninfo.exceptions.InvalidTransactionTypeException;
import com.aninfo.model.Transaction;
import com.aninfo.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction createTransaction(Transaction transaction) {

        return transactionRepository.save(transaction);
    }

    public Collection<Transaction> getTransactions() {
        return transactionRepository.findAll();
    }
    public Collection<Transaction> getTransactionsByCbu(Long cbu){
        return transactionRepository.findAllByCbu(cbu);
    }

    public Optional<Transaction> findById(Long id) {
        return transactionRepository.findById(id);
    }

    public void save(Transaction transaction) {transactionRepository.save(transaction);}

    public void deleteById(Long id) {
        transactionRepository.deleteById(id);
    }
    public void operation(AccountService accountService,Transaction transaction){
        switch (transaction.getType()) {
            case "DEPOSIT":
                accountService.deposit(transaction.getCbu(), transaction.getSum());
                break;
            case "WITHDRAW":
                accountService.withdraw(transaction.getCbu(), transaction.getSum());
                break;
            default:
                throw new InvalidTransactionTypeException("tipo de operacion no valida");
        }
    }

}
