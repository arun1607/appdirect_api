package com.learning.service;

import com.learning.controller.Response;
import com.learning.exception.SubscriptionHandlingException;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by amits on 17/09/16.
 */
public interface SubscriptionService {
    Response create(String eventUrl);

    Response update(String eventUrl) ;

    Response cancel(String eventUrl) ;

    Response status(String eventUrl) ;
}
