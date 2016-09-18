package com.learning.service;

import com.learning.entity.Account;
import com.learning.rest.EventWrapper;

/**
 * Created by amits on 17/09/16.
 */
public interface AccountService {
    Account createAccount(Account account);

    Account createNewAccount();

    Account createAccount(EventWrapper eventWrapper);
}
