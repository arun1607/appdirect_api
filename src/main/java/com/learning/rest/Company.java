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
public class Company {
    private String phoneNumber;

    private String email;

    private String website;

    private String name;

    private String uuid;

    private String country;
}
