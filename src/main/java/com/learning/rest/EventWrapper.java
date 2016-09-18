package com.learning.rest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.learning.entity.Flag;
import com.learning.entity.Marketplace;
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
@JsonPropertyOrder({
        "type",
        "marketplace",
        "applicationUuid",
        "flag",
        "creator",
        "payload",
        "returnUrl",
        "links"
})
public class EventWrapper {

    @JsonProperty("type")
    private EventType type;
    @JsonProperty("marketplace")
    private Marketplace marketplace;
    @JsonProperty("applicationUuid")
    private String applicationUuid;
    @JsonProperty("flag")
    private Flag flag;
    @JsonProperty("creator")
    private User subscribingUser;
    @JsonProperty("payload")
    private Payload payload;
    @JsonProperty("returnUrl")
    private String returnUrl;
    @JsonProperty("links")
    private List<String> links = new ArrayList<>();


}
