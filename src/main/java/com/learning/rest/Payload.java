package com.learning.rest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.learning.entity.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * Created by amits on 13/09/16.
 */
@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "user",
        "company",
        "account",
        "addonInstance",
        "addonBinding",
        "order",
        "notice",
        "configuration"
})
public class Payload {

    @JsonProperty("user")
    private User affectedUser;
    @JsonProperty("company")
    private Company company;
    @JsonProperty("account")
    private Account account;
    @JsonProperty("addonInstance")
    private AddonInstance addonInstance;
    @JsonProperty("addonBinding")
    private AddonBinding addonBinding;
    @JsonProperty("order")
    private Order order;
    @JsonProperty("notice")
    private Notice notice;
    @JsonProperty("configuration")
    private List<Configuration> configuration;
}
