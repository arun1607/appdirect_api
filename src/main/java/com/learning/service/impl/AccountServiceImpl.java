package com.learning.service.impl;

import com.learning.entity.Account;
import com.learning.repository.AccountRepository;
import com.learning.service.AbstractService;
import com.learning.service.AccountService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by amits on 14/09/16.
 */
@Service
@Log4j2
public class AccountServiceImpl extends AbstractService implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Transactional
    @Override
    public Account createAccount(Account account) {
        List<Account> accountList = accountRepository.findByAccountIdentifier(account.getAccountIdentifier());
        Account accountEntity;
        if (accountList.isEmpty()) {
            accountEntity = accountRepository.save(account);
        } else {
            accountEntity = accountList.get(0);
        }
        return accountEntity;
    }

    @Override
    public Account createNewAccount() {
        Account account = new Account();
        return accountRepository.save(account);
    }
}
