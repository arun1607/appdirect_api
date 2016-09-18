package com.learning.service.impl;

import com.learning.entity.Address;
import com.learning.entity.User;
import com.learning.entity.UserType;
import com.learning.exception.DataExistsException;
import com.learning.exception.DataNotFoundException;
import com.learning.exception.UserHandlingException;
import com.learning.repository.UserRepository;
import com.learning.rest.EventWrapper;
import com.learning.service.AbstractService;
import com.learning.service.UserService;
import com.learning.utils.Utils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Created by amits on 14/09/16.
 */
@Service
@Log4j2
public class UserServiceImpl extends AbstractService implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void assignment(String eventUrl) throws UserHandlingException {
        loadEventData(eventUrl);
    }

    @Override
    public void unassignment(String eventUrl) throws UserHandlingException {
        loadEventData(eventUrl);
    }

    @Override
    public User createUser(EventWrapper eventWrapper, UserType userType) {
        log.info("Creating user ");
        User user;
        if (UserType.CREATOR.equals(userType)) {
            user = eventWrapper.getCreator();
        } else {
            user = eventWrapper.getPayload().getUser();
        }
        String openId = Utils.extractOpenId(user.getOpenId());
        User existingUser = userRepository.findByOpenId(openId);
        if (Objects.nonNull(existingUser)) {
            throw new DataExistsException(String.format("User exists with openid %s", openId));
        }
        existingUser = copyProperties(user);
        User userEntity = userRepository.save(existingUser);
        eventWrapper.setCreator(userEntity);
        return userEntity;
    }

    @Override
    public User findByOpenId(String openId) {
        String userOpenId = Utils.extractOpenId(openId);
        com.learning.entity.User existingUser = userRepository.findByOpenId(userOpenId);
        if (Objects.isNull(existingUser)) {
            throw new DataNotFoundException(String.format("User does not exists with openid %s", openId));
        }
        return existingUser;
    }

    private User copyProperties(User user) {
        User userEntity = new User();
        userEntity.setLastName(user.getLastName());
        Address address = user.getAddress();
        if (Objects.nonNull(address)) {
            userEntity.setAddress(address);
            address.setUser(userEntity);
        }
        userEntity.setEmail(user.getEmail());
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLanguage(user.getLanguage());
        userEntity.setLastName(user.getLastName());
        userEntity.setOpenId(Utils.extractOpenId(user.getOpenId()));
        userEntity.setUuid(user.getUuid());

        return userEntity;
    }
}
