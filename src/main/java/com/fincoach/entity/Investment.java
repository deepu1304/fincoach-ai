package com.fincoach.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Investment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @NotBlank(message = "Asset type is required")
    private String assetType; // e.g., "Stock", "Crypto", "Bond"

    @DecimalMin(value = "0.01", message = "Value must be positive")
    private BigDecimal value;

    @NotBlank(message = "Risk level is required")
    private String riskLevel; // e.g., "Low", "Medium", "High"

    private LocalDate date = LocalDate.now();
}