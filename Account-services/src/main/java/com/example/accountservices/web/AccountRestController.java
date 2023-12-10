package com.example.accountservices.web;

import com.example.accountservices.entities.BankAccount;
import com.example.accountservices.repository.BankAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountRestController {
    private BankAccountRepository bankAccountRepository;

    public AccountRestController(BankAccountRepository bankAccountRepository){
        this.bankAccountRepository=bankAccountRepository;
    }
@GetMapping("/accounts")
    public List<BankAccount> accountList(){
       return bankAccountRepository.findAll();
    }
    public BankAccount bankAccountById(@PathVariable String id){
        return bankAccountRepository.findById(id).get();
    }

}
