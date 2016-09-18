package com.learning.rest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.learning.entity.EventType;
import com.learning.entity.Flag;
import com.learning.entity.Marketplace;
import com.learning.entity.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amits on 13/09/16.
 */
@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EventWrapper {

    private EventType type;
    private Marketplace marketplace;
    private String applicationUuid;
    private Flag flag;
    private User creator;
    private Payload payload;
    private String returnUrl;
    private List<String> links = new ArrayList<>();


}
