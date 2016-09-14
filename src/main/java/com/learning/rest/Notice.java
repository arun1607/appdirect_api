package com.learning.rest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by amits on 14/09/16.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "type",
        "message"
})
@Getter
@Setter
public class Notice {

    @JsonProperty("type")
    private String type;
    @JsonProperty("message")
    private Object message;
}
