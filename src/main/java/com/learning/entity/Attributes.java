package com.learning.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Embeddable;

/**
 * Created by amits on 14/09/16.
 */
@JsonInclude(value= JsonInclude.Include.NON_EMPTY, content= JsonInclude.Include.NON_NULL)
@ToString
@Getter
@Setter
@Embeddable
public class Attributes {

    private String favoriteColor;
    private String hourlyRate;
}
