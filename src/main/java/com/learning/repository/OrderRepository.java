package com.learning.repository;

import com.learning.entity.Order;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by amits on 15/09/16.
 */

public interface OrderRepository extends PagingAndSortingRepository<Order, Long> {
}
