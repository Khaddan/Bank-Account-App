package com.example.accountservices;

import com.example.accountservices.entities.BankAccount;
import com.example.accountservices.enums.AccountType;
import com.example.accountservices.repository.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
public class AccountServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServicesApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(BankAccountRepository bankAccountRepository){
        return args -> {
            BankAccount bankAccount1=BankAccount.builder()
                    .accountId(UUID.randomUUID().toString())
                    .currency("MAD")
                    .balance(98000)
                    .createAt(LocalDate.now())
                    .type(AccountType.CURRENT_ACCOUNT)
                    .customerId(Long.valueOf(1))
                    .build();
            BankAccount bankAccount2=BankAccount.builder()
                    .accountId(UUID.randomUUID().toString())
                    .currency("MAD")
                    .balance(318000)
                    .createAt(LocalDate.now())
                    .type(AccountType.SAVING_ACCOUNT)
                    .customerId(Long.valueOf(2))
                    .build();
            BankAccount bankAccount3=BankAccount.builder()
                    .accountId(UUID.randomUUID().toString())
                    .currency("MAD")
                    .balance(53000)
                    .createAt(LocalDate.now())
                    .type(AccountType.CURRENT_ACCOUNT)
                    .customerId(Long.valueOf(3))
                    .build();
            bankAccountRepository.save(bankAccount1);
            bankAccountRepository.save(bankAccount2);
            bankAccountRepository.save(bankAccount3);
        };
    }

}
