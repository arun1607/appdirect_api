package com.learning.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by amits on 14/09/16.
 */
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
public class SubscriptionUser {

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
    private String address;
    @JsonProperty("attributes")
    private Attributes attributes;
}
