package com.learning.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by amits on 15/09/16.
 */
@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity implements Serializable{

    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;

    private Timestamp created;

    private Timestamp updated;

    @PrePersist
    private void populateCreationDate() {
        created = new Timestamp(new Date().getTime());
    }

    @PreUpdate
    private void populateUpdateDate() {
        updated = new Timestamp(new Date().getTime());
    }
}
