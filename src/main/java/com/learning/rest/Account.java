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
        "accountIdentifier",
        "status",
        "parentAccountIdentifier"
})
@Getter
@Setter
public class Account {

    @JsonProperty("accountIdentifier")
    private String accountIdentifier;
    @JsonProperty("status")
    private AccountStatus status;
    @JsonProperty("parentAccountIdentifier")
    private String parentAccountIdentifier;

}