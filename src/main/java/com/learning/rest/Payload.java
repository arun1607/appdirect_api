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
    private String user;
    @JsonProperty("company")
    private Company company;
    @JsonProperty("account")
    private Account account;
    @JsonProperty("addonInstance")
    private String addonInstance;
    @JsonProperty("addonBinding")
    private String addonBinding;
    @JsonProperty("order")
    private Order order;
    @JsonProperty("notice")
    private String notice;
    @JsonProperty("configuration")
    private Configuration configuration;
}
