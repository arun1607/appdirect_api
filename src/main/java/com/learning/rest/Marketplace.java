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
        "partner",
        "baseUrl"
})
public class Marketplace {

    @JsonProperty("partner")
    private String partner;
    @JsonProperty("baseUrl")
    private String baseUrl;
}
