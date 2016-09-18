package com.learning.service;

import com.learning.entity.Order;
import com.learning.rest.EventWrapper;

/**
 * Created by amits on 17/09/16.
 */
public interface OrderService {
    Order createOrder(Order order);

    Order createOrder(EventWrapper eventWrapper);
}
