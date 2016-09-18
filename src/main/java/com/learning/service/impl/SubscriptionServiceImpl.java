package com.learning.service.impl;

import com.learning.controller.Response;
import com.learning.entity.*;
import com.learning.exception.SubscriptionHandlingException;
import com.learning.repository.EventRepository;
import com.learning.rest.EventWrapper;
import com.learning.service.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by amits on 14/09/16.
 */
@Service
@Log4j2
public class SubscriptionServiceImpl extends AbstractService implements SubscriptionService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private MarketplaceService marketplaceService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private CompanyService companyService;

    @Transactional
    @Override
    public Response create(String eventUrl) {

        EventWrapper eventWrapper = loadEventData(eventUrl);

        com.learning.rest.User subscribingUser = eventWrapper.getSubscribingUser();

        Marketplace marketplace = marketplaceService.createMarketplace(eventWrapper.getMarketplace());
        Order orderEntity = orderService.createOrder(eventWrapper.getPayload().getOrder());
        Account accountEntity = accountService.createNewAccount();
        Company companyEntity = companyService.createCompany(eventWrapper.getPayload().getCompany());
        User userEntity = userService.createUser(subscribingUser);
        userEntity.setAccount(accountEntity);


        Event event = new Event();
        event.setCompany(companyEntity);
        event.setSubscriptionUser(userEntity);
        event.setMarketplace(marketplace);
        event.setApplicationUuid(eventWrapper.getApplicationUuid());
        event.setCompany(eventWrapper.getPayload().getCompany());
        event.setFlag(eventWrapper.getFlag());
        event.setConfigurations(eventWrapper.getPayload().getConfiguration());
        event.setOrder(orderEntity);

        eventRepository.save(event);

        return Response.success(accountEntity.getAccountIdentifier());
    }

    @Override
    public Response update(String eventUrl) throws SubscriptionHandlingException {
        EventWrapper eventWrapper = loadEventData(eventUrl);
        return null;
    }

    @Override
    public Response cancel(String eventUrl) throws SubscriptionHandlingException {
        EventWrapper eventWrapper = loadEventData(eventUrl);
        return null;
    }

    @Override
    public Response status(String eventUrl) throws SubscriptionHandlingException {
        EventWrapper eventWrapper = loadEventData(eventUrl);
        return null;
    }
}
