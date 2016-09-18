package com.learning.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by amits on 13/09/16.
 */
@JsonInclude(value= JsonInclude.Include.NON_EMPTY, content= JsonInclude.Include.NON_NULL)

@Getter
@Setter
@ToString
@Entity
@Table(name = "app_order")
public class Order extends BaseEntity {

    private String editionCode;
    private String addonOfferingCode;
    private PricingDuration pricingDuration;

    @OneToMany(mappedBy = "order")
    private List<Item> items = new ArrayList<>();

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Subscription subscription;

}
