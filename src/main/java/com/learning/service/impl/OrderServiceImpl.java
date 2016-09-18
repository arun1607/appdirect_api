package com.learning.service.impl;

import com.learning.controller.ResponseErrorCode;
import com.learning.entity.Order;
import com.learning.exception.InvalidPayloadDataException;
import com.learning.repository.OrderRepository;
import com.learning.rest.EventWrapper;
import com.learning.rest.Payload;
import com.learning.service.AbstractService;
import com.learning.service.OrderService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

/**
 * Created by amits on 14/09/16.
 */
@Service
@Log4j2
public class OrderServiceImpl extends AbstractService implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order createOrder(EventWrapper eventWrapper) {
        log.info("Creating Order ");
        Payload payload = eventWrapper.getPayload();
        if (Objects.isNull(payload)) {
            throw new InvalidPayloadDataException(ResponseErrorCode.INVALID_RESPONSE,"Payload can not be null");
        }
        Order order = payload.getOrder();
        if (Objects.isNull(order)) {
            throw new InvalidPayloadDataException(ResponseErrorCode.INVALID_RESPONSE,"Order can not be null");
        }
        order = orderRepository.save(order);
        payload.setOrder(order);
        return order;
    }

    @Transactional
    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

}
