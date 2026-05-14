package com.fincoach.service;

import com.fincoach.entity.Investment;
import com.fincoach.entity.User;
import com.fincoach.repository.InvestmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvestmentService {

    private final InvestmentRepository investmentRepository;
    private final UserService userService;

    public InvestmentService(InvestmentRepository investmentRepository, UserService userService) {
        this.investmentRepository = investmentRepository;
        this.userService = userService;
    }

    public Investment createInvestment(User user, Investment investment) {
        investment.setUser(user);
        return investmentRepository.save(investment);
    }

    public List<Investment> getUserInvestments(User user) {
        return investmentRepository.findByUser(user);
    }
}