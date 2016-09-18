package com.learning.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Embeddable;

/**
 * Created by amits on 13/09/16.
 */
@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "unit",
        "quantity"
})
@Embeddable
public class Item {

    @JsonProperty("unit")
    private String unit;
    @JsonProperty("quantity")
    private Integer quantity;

}
