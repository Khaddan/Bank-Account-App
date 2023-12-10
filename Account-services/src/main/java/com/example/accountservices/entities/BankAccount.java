package com.example.accountservices.entities;

import com.example.accountservices.enums.AccountType;
import com.example.accountservices.model.Customer;
import jakarta.persistence.*;
import lombok.*;

import java.security.cert.CertPathBuilder;
import java.time.LocalDate;
@Entity @Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString @Builder
public class BankAccount {
    @Id
    private String accountId;
    private double balance;
    private LocalDate createAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    @Transient
    private Customer customer;
    private Long customerId;


}
