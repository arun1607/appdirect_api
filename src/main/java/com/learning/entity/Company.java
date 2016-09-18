package com.learning.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.util.Objects;
import java.util.UUID;

/**
 * Created by amits on 15/09/16.
 */
@JsonInclude(value= JsonInclude.Include.NON_EMPTY, content= JsonInclude.Include.NON_NULL)

@Getter
@Setter
@ToString
@Entity
@Table(name = "app_event_company")
public class Company extends BaseEntity {

    private String uuid;
    private String externalId;
    private String name;
    private String email;
    private String phoneNumber;
    private String website;
    private String country;

    @PrePersist
    private void populateCreationDate() {
        if (Objects.isNull(uuid))
            uuid = UUID.randomUUID().toString();
    }
}
