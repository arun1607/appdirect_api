package com.learning.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * Created by amits on 14/09/16.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "app_user")
@Getter
@Setter
public class User extends BaseEntity {

    private String uuid;
    private String openId;
    private String email;
    private String firstName;
    private String lastName;
    private String language;


    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Address address;

    @Embedded
    private Attributes attributes;

    @JoinColumn(name = "account_id")
    @OneToOne
    @JsonIgnore
    private Account account;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Subscription> userSubscriptions = new ArrayList<>();



    @PrePersist
    private void populateCreationDate() {
        if (Objects.isNull(uuid))
            uuid = UUID.randomUUID().toString();

    }
}
