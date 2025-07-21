package com.example.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.entity.Account;
import com.example.repository.AccountRepository;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;
    
   public Account register(Account account){
    Account exists = accountRepository.findByUserName(account.getUsername());
    if (exists != null){
        return null;
    }

    return accountRepository.save(account);
}

    public Account login(Account account){
        Account exists = accountRepository.findByUserName(account.getUsername());
        if (exists != null && exists.getPassword().equals(account.getPassword())){
            return exists;
        }
        return null;
    }

}
