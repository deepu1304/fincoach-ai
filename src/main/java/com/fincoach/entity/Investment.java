package com.fincoach.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
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

    @NotNull(message = "Asset type is required")
    @Enumerated(EnumType.STRING)
    private AssetType assetType;

    @DecimalMin(value = "0.01", message = "Value must be positive")
    private BigDecimal value;

    @NotNull(message = "Risk level is required")
    @Enumerated(EnumType.STRING)
    private RiskLevel riskLevel;

    private LocalDate date = LocalDate.now();
}