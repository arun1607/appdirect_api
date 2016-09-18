package com.learning.service;

import com.learning.entity.Event;
import com.learning.rest.EventWrapper;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by amits on 18/09/16.
 */
public interface EventService {
    @Transactional
    Event createEvent(EventWrapper eventWrapper);
}
