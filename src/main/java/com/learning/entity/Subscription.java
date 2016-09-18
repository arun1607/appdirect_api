package com.learning.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
@JsonInclude(value= JsonInclude.Include.NON_EMPTY, content= JsonInclude.Include.NON_NULL)
@ToString
public class Subscription extends BaseEntity {

    private String applicationUuid;

    @Enumerated(EnumType.STRING)
    private SubscriptionStatus status;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "subscription")
    private List<Order> orders = new ArrayList<>();

}
