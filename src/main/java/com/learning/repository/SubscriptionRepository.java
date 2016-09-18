package com.learning.repository;

import com.learning.entity.Account;
import com.learning.entity.Subscription;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by amits on 15/09/16.
 */

public interface SubscriptionRepository extends PagingAndSortingRepository<Subscription, Long> {
}
