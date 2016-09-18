package com.learning.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * Created by amits on 14/09/16.
 */
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
    @JoinColumn(name = "account_id")
    @OneToOne
    private Account account;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Address address;

    @OneToMany(mappedBy = "user")
    private List<Attributes> attributes;

    @PrePersist
    private void populateCreationDate() {
        if (Objects.isNull(uuid))
            uuid = UUID.randomUUID().toString();


    }
}
