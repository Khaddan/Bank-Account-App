package com.example.accountservices;

import com.example.accountservices.clients.CustomerRestClient;
import com.example.accountservices.entities.BankAccount;
import com.example.accountservices.enums.AccountType;
import com.example.accountservices.repository.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServicesApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(BankAccountRepository bankAccountRepository , CustomerRestClient customerRestClient){
        return args -> {
            customerRestClient.allCustomers().forEach(cust -> {
                BankAccount bankAccount1=BankAccount.builder()
                        .accountId(UUID.randomUUID().toString())
                        .currency("MAD")
                        .balance(Math.random()+98000)
                        .createAt(LocalDate.now())
                        .type(AccountType.CURRENT_ACCOUNT)
                        .customerId(cust.getId())
                        .build();
                BankAccount bankAccount2=BankAccount.builder()
                        .accountId(UUID.randomUUID().toString())
                        .currency("MAD")
                        .balance(Math.random()+318000)
                        .createAt(LocalDate.now())
                        .type(AccountType.SAVING_ACCOUNT)
                        .customerId(cust.getId())
                        .build();

                bankAccountRepository.save(bankAccount1);
                bankAccountRepository.save(bankAccount2);

            });

        };
    }

}
