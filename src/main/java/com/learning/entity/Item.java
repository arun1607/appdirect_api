package com.learning.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
@Table(name = "order_item")
@Entity
public class Item extends BaseEntity {

    @JsonProperty("unit")
    private String unit;
    @JsonProperty("quantity")
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

}
