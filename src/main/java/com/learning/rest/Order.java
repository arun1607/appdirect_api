package com.learning.rest;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by amits on 13/09/16.
 */
@Getter
@Setter
@ToString
public class Order {
    private String pricingDuration;

    private Item[] item;

    private String editionCode;
}
