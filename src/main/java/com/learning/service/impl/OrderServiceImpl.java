package com.learning.service.impl;

import com.learning.entity.Order;
import com.learning.repository.OrderRepository;
import com.learning.service.AbstractService;
import com.learning.service.OrderService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by amits on 14/09/16.
 */
@Service
@Log4j2
public class OrderServiceImpl extends AbstractService implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Transactional
    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

}
