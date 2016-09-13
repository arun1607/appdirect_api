package com.learning.rest;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by amits on 13/09/16.
 */
@Getter
@Setter
@ToString
public class Event {
    private String returnUrl;

    private String flag;

    private Payload payload;

    private String type;

    private Marketplace marketplace;

    private Creator creator;
}
