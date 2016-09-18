package com.learning.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Created by amits on 15/09/16.
 */
@JsonInclude(value= JsonInclude.Include.NON_EMPTY, content= JsonInclude.Include.NON_NULL)

@Getter
@Setter
@ToString
@Entity
@Table(name = "app_user_address")
public class Address extends BaseEntity {
    private String city;
    private String country;
    private String firstName;
    private String fullName;
    private String lastName;
    private String state;
    private String street1;
    private String zip;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
