package com.learning.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by amits on 14/09/16.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id"
})
@Getter
@Setter
@Entity
@Table(name = "app_addons_instance")
public class AddonInstance extends BaseEntity {
    @JsonProperty("id")
    private String addonInstanceId;
}
