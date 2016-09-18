package com.learning.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by amits on 13/09/16.
 */
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
