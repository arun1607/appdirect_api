package com.learning.rest;

import com.learning.entity.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by amits on 13/09/16.
 */
@Getter
@Setter
@ToString
public class Payload {

    private User user;
    private Company company;
    private Account account;
    private AddonInstance addonInstance;
    private AddonBinding addonBinding;
    private Order order;
    private Notice notice;
    private Configuration configuration;
}
