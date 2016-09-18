package com.learning.entity;

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
@Entity
@Table(name = "app_order")
public class Order extends BaseEntity {

    private String editionCode;
    private String addonOfferingCode;
    private PricingDuration pricingDuration;

    @OneToMany(mappedBy = "order")
    private List<Item> items = new ArrayList<>();

}
