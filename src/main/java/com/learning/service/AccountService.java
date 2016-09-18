package com.learning.service;

import com.learning.entity.Account;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by amits on 17/09/16.
 */
public interface AccountService {
    Account createAccount(Account account);

    Account createNewAccount();
}
