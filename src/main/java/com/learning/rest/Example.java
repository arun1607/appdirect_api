package com.learning.rest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amits on 14/09/16.
 */
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
@Getter
@Setter
public class Example {

    @JsonProperty("type")
    private String type;
    @JsonProperty("marketplace")
    private Marketplace marketplace;
    @JsonProperty("applicationUuid")
    private Object applicationUuid;
    @JsonProperty("flag")
    private String flag;
    @JsonProperty("creator")
    private Creator creator;
    @JsonProperty("payload")
    private Payload payload;
    @JsonProperty("returnUrl")
    private Object returnUrl;
    @JsonProperty("links")
    private List<String> links = new ArrayList<>();

}
