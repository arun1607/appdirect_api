package com.learning.service.impl;

import com.learning.entity.Account;
import com.learning.entity.AccountStatus;
import com.learning.entity.User;
import com.learning.exception.InvalidPayloadDataException;
import com.learning.repository.AccountRepository;
import com.learning.rest.EventWrapper;
import com.learning.rest.Payload;
import com.learning.service.AbstractService;
import com.learning.service.AccountService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * Created by amits on 14/09/16.
 */
@Service
@Log4j2
public class AccountServiceImpl extends AbstractService implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    @Transactional
    public Account createAccount(EventWrapper eventWrapper) {
        log.info("Creating Account ");
        Payload payload = eventWrapper.getPayload();
        if (Objects.isNull(payload)) {
            throw new InvalidPayloadDataException("Payload can not be null");
        }
        Account account = payload.getAccount();
        if (Objects.isNull(account)) {
            account = new Account();
            account.setStatus(AccountStatus.ACTIVE);
            account = accountRepository.save(account);
        }
        payload.setAccount(account);
        User creator = eventWrapper.getCreator();
        creator.setAccount(account);
        return account;
    }

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
