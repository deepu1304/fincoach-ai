package com.fincoach.controller;

import com.fincoach.entity.Transaction;
import com.fincoach.entity.User;
import com.fincoach.service.TransactionService;
import com.fincoach.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;
    private final UserService userService;

    public TransactionController(TransactionService transactionService, UserService userService) {
        this.transactionService = transactionService;
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> createTransaction(Authentication auth, @RequestBody Transaction transaction) {
        User user = userService.getCurrentUser(auth);
        return ResponseEntity.ok(transactionService.createTransaction(user, transaction));
    }

    @GetMapping
    public ResponseEntity<?> getUserTransactions(Authentication auth) {
        User user = userService.getCurrentUser(auth);
        return ResponseEntity.ok(transactionService.getUserTransactions(user));
    }

    private User getCurrentUser(Authentication auth) {
        String email = auth.getName();
        return userService.loadUserByUsername(email).getUser();
    }
}