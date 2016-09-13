package com.learning.rest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by amits on 13/09/16.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "uuid",
        "openId",
        "email",
        "firstName",
        "lastName",
        "language",
        "address",
        "attributes"
})
@Getter
@Setter
@ToString
public class Creator {

    @JsonProperty("uuid")
    private String uuid;
    @JsonProperty("openId")
    private String openId;
    @JsonProperty("email")
    private String email;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("language")
    private String language;
    @JsonProperty("address")
    private Object address;
    @JsonProperty("attributes")
    private Object attributes;
}
