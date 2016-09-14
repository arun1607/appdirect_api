package com.learning.rest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
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
        "editionCode",
        "addonOfferingCode",
        "pricingDuration",
        "items"
})
public class Order {

    @JsonProperty("editionCode")
    private String editionCode;
    @JsonProperty("addonOfferingCode")
    private Object addonOfferingCode;
    @JsonProperty("pricingDuration")
    private PricingDuration pricingDuration;
    @JsonProperty("items")
    private List<Item> items = new ArrayList<Item>();
}
