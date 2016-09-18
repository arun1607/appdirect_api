package com.learning.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
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
@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "firstName",
        "fullName",
        "lastName",
        "city",
        "country",
        "phone",
        "state",
        "street1",
        "street2",
        "zip"
})
@Entity
@Table(name = "app_user_address")
public class Address extends BaseEntity {
    private String firstName;
    private String fullName;
    private String lastName;
    private String city;
    private String country;
    private String phone;
    private String state;
    private String street1;
    private String street2;
    private String zip;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
