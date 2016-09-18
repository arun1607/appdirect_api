package com.learning.repository;

import com.learning.entity.Account;
import com.learning.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by amits on 15/09/16.
 */

public interface AccountRepository extends PagingAndSortingRepository<Account, Long> {

    List<Account> findByAccountIdentifier(String accountIdentifier);
}
