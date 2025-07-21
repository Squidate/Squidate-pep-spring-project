package com.example.repository;
import com.example.entity.Account;

public interface AccountRepository {
    Account save(Account account);
    Account findByUserName(String username);
}
