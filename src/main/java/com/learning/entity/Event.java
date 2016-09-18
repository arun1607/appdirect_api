package com.learning.entity;

import com.learning.rest.EventType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Created by amits on 15/09/16.
 */
@Entity
@Table(name = "app_event")
@Getter
@Setter
public class Event extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private EventType eventType;

    @OneToOne
    @JoinColumn(name = "marketplace_id")
    private Marketplace marketplace;

    private String applicationUuid;
    @Enumerated(EnumType.STRING)
    private Flag flag;

    @OneToOne
    @JoinColumn(name = "creator_id")
    private User creator;

    private String returnUrl;

    @OneToOne
    @JoinColumn(name = "subscriber_id")
    private User subscriptionUser;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToOne
    @JoinColumn(name = "notice_id")
    private Notice notice;

    @OneToMany(mappedBy = "event",cascade = CascadeType.ALL)
    private List<Configuration> configurations;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
