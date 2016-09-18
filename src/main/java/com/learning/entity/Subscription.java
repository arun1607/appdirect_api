package com.learning.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by amits on 15/09/16.
 */
@Entity
@Table(name = "app_user_subscription")
@Getter
@Setter
public class Subscription extends BaseEntity {

    private String applicationUuid;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "subscription")
    private List<Order> orders = new ArrayList<>();

}
