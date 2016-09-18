package com.learning.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * Created by amits on 13/09/16.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@ToString
@Entity
@Table(name = "app_event_configuration")
public class Configuration extends BaseEntity {

    private String domain;

    private String name;

    @JsonProperty("entry")
    @OneToMany(mappedBy = "configuration")
    private List<ConfigurationEntry> entries;

    @OneToOne
    @JoinColumn(name = "event_id")
    private Event event;
}
