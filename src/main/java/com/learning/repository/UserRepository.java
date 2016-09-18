package com.learning.repository;

import com.learning.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by amits on 15/09/16.
 */

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    User findByOpenId(String openId);

    User findByEmail(String email);

    User findByAccountId(String accountId);
}
