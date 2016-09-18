package com.learning.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
        "key",
        "value"
})
@Getter
@Setter
@Entity
@Table(name = "app_configuration_entry")
public class ConfigurationEntry extends BaseEntity {
    @JsonProperty("key")
    @Column(name = "entry_key")
    private String key;
    @JsonProperty("value")
    @Column(name = "entry_val")
    private String value;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "configuration_id")
    private Configuration configuration;
}
