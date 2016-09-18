package com.learning.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by amits on 13/09/16.
 */
@Getter
@Setter
@ToString

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "partner",
        "baseUrl"
})
@Entity
@Table(name = "app_marketplace")
public class Marketplace extends BaseEntity {

    @JsonProperty("partner")
    private String partner = "APPDIRECT";
    @JsonProperty("baseUrl")
    private String baseUrl;
}
