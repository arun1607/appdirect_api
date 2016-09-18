package com.learning.service;

import com.learning.entity.User;
import com.learning.entity.UserType;
import com.learning.rest.EventWrapper;

/**
 * Created by amits on 17/09/16.
 */
public interface UserService {
    void assignment(String eventUrl);

    void unassignment(String eventUrl);


    User findByOpenId(String openId);

    User createUser(EventWrapper eventWrapper, UserType creator);
}
