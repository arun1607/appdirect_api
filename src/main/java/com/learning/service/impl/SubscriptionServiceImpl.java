package com.learning.service.impl;

import com.learning.controller.Response;
import com.learning.entity.*;
import com.learning.repository.EventRepository;
import com.learning.rest.EventWrapper;
import com.learning.service.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    @Autowired
    private EventService eventService;

    @Transactional
    @Override
    public Response create(String eventUrl) {

        EventWrapper eventWrapper = loadEventData(eventUrl);
        User user = userService.createUser(eventWrapper, UserType.CREATOR);

        marketplaceService.createMarketplace(eventWrapper);


        Order orderEntity = orderService.createOrder(eventWrapper);


        Account accountEntity = accountService.createAccount(eventWrapper);


        companyService.createCompany(eventWrapper);

        Subscription subscription = new Subscription();
        subscription.setStatus(SubscriptionStatus.ACTIVE);
        user.getUserSubscriptions().add(subscription);
        orderEntity.setSubscription(subscription);
        subscription.getOrders().add(orderEntity);
        subscription.setUser(user);

        eventService.createEvent(eventWrapper);
        log.info("Created account with account identifier {}", accountEntity.getAccountIdentifier());
        return Response.success(accountEntity.getAccountIdentifier());
    }

    @Override
    @Transactional
    public Response update(String eventUrl) {
        EventWrapper eventWrapper = loadEventData(eventUrl);
        User creator = eventWrapper.getCreator();
        User user = userService.findByOpenId(creator.getOpenId());
        Account account = user.getAccount();
        List<Subscription> subscriptions = user.getUserSubscriptions();

        return Response.success(account.getAccountIdentifier());
    }

    @Override
    @Transactional
    public Response cancel(String eventUrl) {
        EventWrapper eventWrapper = loadEventData(eventUrl);
        User creator = eventWrapper.getCreator();
        User user = userService.findByOpenId(creator.getOpenId());
        Account account = user.getAccount();
        List<Subscription> subscriptions = user.getUserSubscriptions();
        subscriptions.forEach(subscription -> subscription.setStatus(SubscriptionStatus.CANCELLED));

        return Response.success(account.getAccountIdentifier());
    }

    @Override
    @Transactional
    public Response status(String eventUrl) {
        EventWrapper eventWrapper = loadEventData(eventUrl);
        accountService.update(eventWrapper);
        return Response.success(eventWrapper.getPayload().getAccount().getAccountIdentifier());
    }
}
