package com.learning.rest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.learning.entity.Address;
import com.learning.entity.Attributes;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

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
public class User {
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
    private Address address;
    @JsonProperty("attributes")
    private List<Attributes> attributes;
}
