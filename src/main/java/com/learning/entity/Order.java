package com.learning.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

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
        "item"
})
@Entity
@Table(name = "app_order")
public class Order extends BaseEntity {

    @JsonProperty("editionCode")
    private String editionCode;
    @JsonProperty("addonOfferingCode")
    private String addonOfferingCode;
    @JsonProperty("pricingDuration")
    private PricingDuration pricingDuration;
    @JsonProperty("item")
    @Embedded
    private Item item;

}
