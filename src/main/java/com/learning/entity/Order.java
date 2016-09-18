package com.learning.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
        "item",
        "items"
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

    @OneToMany(mappedBy = "order")
    private List<Item> items = new ArrayList<>();


    @JsonProperty("item")
    public void setItem(Item item) {
        this.items.add(item);
    }

    @JsonProperty("items")
    public void setItems(List<Item> items) {
        this.items.addAll(items);
    }
}
