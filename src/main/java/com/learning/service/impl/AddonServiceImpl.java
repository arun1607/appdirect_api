package com.learning.service.impl;

import com.learning.entity.Marketplace;
import com.learning.entity.User;
import com.learning.repository.EventRepository;
import com.learning.rest.EventWrapper;
import com.learning.service.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by amits on 14/09/16.
 */
@Service
@Log4j2
public class AddonServiceImpl extends AbstractService implements AddonService {
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

    @Override
    public void cancel(String eventUrl) {
        EventWrapper eventWrapper = loadEventData(eventUrl);
    }

    @Override
    public void order(String eventUrl) {
        EventWrapper eventWrapper = loadEventData(eventUrl);
    }

    @Override
    public void change(String eventUrl) {
        EventWrapper eventWrapper = loadEventData(eventUrl);
    }

    @Override
    public void bind(String eventUrl) {
        EventWrapper eventWrapper = loadEventData(eventUrl);

        com.learning.rest.User subscribingUser = eventWrapper.getSubscribingUser();
        Marketplace marketplace = marketplaceService.createMarketplace(eventWrapper.getMarketplace());
        User user = userService.findByOpenId(subscribingUser.getOpenId());


    }

    @Override
    public void unbind(String eventUrl) {
        EventWrapper eventWrapper = loadEventData(eventUrl);
    }
}
