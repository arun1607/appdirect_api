package com.learning.service;

import com.learning.rest.User;

/**
 * Created by amits on 17/09/16.
 */
public interface UserService {
    void assignment(String eventUrl);

    void unassignment(String eventUrl);

    com.learning.entity.User createUser(User user);

    com.learning.entity.User findByOpenId(String openId);
}
