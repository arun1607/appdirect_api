package com.learning.service.impl;

import com.learning.entity.Event;
import com.learning.entity.User;
import com.learning.exception.InvalidPayloadDataException;
import com.learning.repository.EventRepository;
import com.learning.rest.EventWrapper;
import com.learning.rest.Payload;
import com.learning.service.EventService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

/**
 * Created by amits on 18/09/16.
 */
@Service
@Log4j2
public class EventServiceImpl implements EventService {
    @Autowired
    private EventRepository eventRepository;

    @Override
    @Transactional
    public Event createEvent(EventWrapper eventWrapper) {
        User user = eventWrapper.getCreator();
        Payload payload = eventWrapper.getPayload();
        if (Objects.isNull(payload)) {
            throw new InvalidPayloadDataException("Payload can not be null");
        }
        log.info("Creating event ");
        Event event = new Event();
        event.setEventType(eventWrapper.getType());
        event.setCompany(payload.getCompany());
        event.setCreator(user);
        event.setMarketplace(eventWrapper.getMarketplace());
        event.setApplicationUuid(eventWrapper.getApplicationUuid());
        event.setCompany(payload.getCompany());
        event.setFlag(eventWrapper.getFlag());
        event.setConfiguration(payload.getConfiguration());
        event.setOrder(payload.getOrder());
        return eventRepository.save(event);
    }
}
