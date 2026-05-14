package com.fincoach.repository;

import com.fincoach.entity.Investment;
import com.fincoach.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface InvestmentRepository extends JpaRepository<Investment, Long> {
    List<Investment> findByUser(User user);
}