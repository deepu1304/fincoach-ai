package com.fincoach.service;

import com.fincoach.entity.Transaction;
import com.fincoach.entity.User;
import com.fincoach.repository.TransactionRepository;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final UserService userService;

    public TransactionService(TransactionRepository transactionRepository, UserService userService) {
        this.transactionRepository = transactionRepository;
        this.userService = userService;
    }

    public User getCurrentUser(Authentication auth) {
        String email = auth.getName();
        return userService.loadUserByUsername(email).getUser();
    }

    public Transaction createTransaction(User user, Transaction transaction) {
        transaction.setUser(user);
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getUserTransactions(User user) {
        return transactionRepository.findByUser(user);
    }
}