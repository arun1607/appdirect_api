package com.learning.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by amits on 14/09/16.
 */
@JsonInclude(value= JsonInclude.Include.NON_EMPTY, content= JsonInclude.Include.NON_NULL)

@Getter
@Setter
@Entity
@Table(name = "app_configuration_entry")
public class ConfigurationEntry extends BaseEntity {
    @Column(name = "entry_key")
    private String key;
    @Column(name = "entry_val")
    private String value;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "configuration_id")
    private Configuration configuration;
}
