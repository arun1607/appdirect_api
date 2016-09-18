package com.learning.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * Created by amits on 13/09/16.
 */
@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "domain", "name", "entry"
})
@Entity
@Table(name = "app_event_configuration")
public class Configuration extends BaseEntity {

    @JsonProperty("domain")
    private String domain;

    @JsonProperty("name")
    private String name;

    @JsonProperty("entry")
    @OneToMany(mappedBy = "configuration")
    private List<ConfigurationEntry> entries;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;
}
