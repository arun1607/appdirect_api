package com.learning.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonInclude(value= JsonInclude.Include.NON_EMPTY, content= JsonInclude.Include.NON_NULL)

@Getter
@Setter
@ToString
@Table(name = "order_item")
@Entity
public class Item extends BaseEntity {

    private String unit;
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

}
