package com.learning.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by amits on 14/09/16.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "favoriteColor",
        "hourlyRate"
})
@Getter
@Setter
@Entity
@Table(name = "app_user_attributes")
public class Attributes extends BaseEntity{

    @JsonProperty("favoriteColor")
    private String favoriteColor;
    @JsonProperty("hourlyRate")
    private String hourlyRate;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
