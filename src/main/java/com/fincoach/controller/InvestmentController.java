package com.fincoach.controller;

import com.fincoach.entity.Investment;
import com.fincoach.entity.User;
import com.fincoach.service.InvestmentService;
import com.fincoach.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/investments")
public class InvestmentController {

    private final InvestmentService investmentService;
    private final UserService userService;

    public InvestmentController(InvestmentService investmentService, UserService userService) {
        this.investmentService = investmentService;
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> createInvestment(Authentication auth, @RequestBody Investment investment) {
        User user = userService.getCurrentUser(auth);
        return ResponseEntity.ok(investmentService.createInvestment(user, investment));
    }

    @GetMapping
    public ResponseEntity<?> getUserInvestments(Authentication auth) {
        User user = userService.getCurrentUser(auth);
        return ResponseEntity.ok(investmentService.getUserInvestments(user));
    }

    private User getCurrentUser(Authentication auth) {
        String email = auth.getName();
        return userService.loadUserByUsername(email).getUser();
    }
}